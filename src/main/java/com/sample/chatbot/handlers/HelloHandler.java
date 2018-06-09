package com.sample.chatbot.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ai.chatbot.framework.request.LexRequest;
import com.ai.chatbot.framework.response.LexResponse;
import com.ai.chatbot.framework.response.Message;
import com.ai.chatbot.framework.response.action.CloseDialogAction;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sample.chatbot.framework.handlers.AbstractLexRequestHandler;


public class HelloHandler extends AbstractLexRequestHandler implements RequestStreamHandler{
    
	private Logger logger = LogManager.getLogger(getClass().getName());
	
	/**
	 * 
	 */
	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        byte[] requestBytes = IOUtils.toByteArray(inputStream);
        if (logger.isDebugEnabled()) {
            logger.debug("Request Json:\n {}", new String(requestBytes));
        }
        byte[] responseBytes = null;
        try {
            LexRequest lexRequest = LexRequest.fromJson(requestBytes);
            
            if(lexRequest != null)
            {
            	// Get session
            	Map<String,String> sessionAttributes = null;        	
            	if(lexRequest.getSessionAttributes() != null)
            		sessionAttributes = new HashMap<>(lexRequest.getSessionAttributes());
            	else
            		sessionAttributes = new HashMap<>();
            	
            	// Pull attribute name from Request
            	String firstName = lexRequest.getCurrentIntent().getSlots().get("firstname");
            	
            	// Store is session for future use
            	saveObjectIntoSession(sessionAttributes,"firstname", firstName, new TypeReference<String>() {});
            	
            	// Create Response
            	LexResponse lexResponse = new LexResponse(new CloseDialogAction("Fulfilled", new Message("PlainText","Hello "+ firstName + ", Hope your are doing great")),sessionAttributes);
                responseBytes = lexResponse.toJson();
                if (logger.isDebugEnabled()) {
                    logger.debug("Response Json:\n {}", new String(responseBytes));
                }
            }
            else
                throw new RuntimeException("Request is null: ");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        outputStream.write(responseBytes);
    }  
	
	
}