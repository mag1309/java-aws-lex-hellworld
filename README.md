# java-aws-lex-hellworld
A sample program which ask user to provide their name and display the same with hello string.

This program uses library available at https://github.com/mag1309/java-aws-lex-api/releases/download/1.0/java-lex-core-1.0.jar as included in pom.xml.

Steps to run the program:

1. Download jar avaiable at https://github.com/mag1309/java-aws-lex-hellworld/releases/download/1.0/lex-hello-word-1.0.jar

2. Go to AWS Lambda(available on AWS Service List) and create a new function. You can give any name to function (i.e. HelloWord), select JDK8 as run time and choose default role to create new lambda function.

3. Go to Function Code section after function creation, choose upload zip/jar option, runtime as jdk8, provide handler as com.sample.chatbot.handlers.HelloHandler::handleRequest, choose downloaded jar file in step-1 from your computer and press "Save" button (top right corner). Wait for file upload. You can create Test cases also.

4. Now create ChatBot with AWS Lex. Go to Lex console and create a custom chatbot with 5-10 minute of session duration. You will create an Intent with a slot name "fistname" to run the chatbot. 

5. After Intent creation, Build and Test the bot.

6. Sample chat communication will be as below
   Hi
   What is your name ?
   Test
   Hello Test, How are you doing?
   
Mail me @mag1309@yahoo.com if you are not able to run the code.
