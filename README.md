# Java AWS Lambda Lex Helloword Program
A sample program which ask user to provide their name and display the same with hello string.

This program uses AWS Lambda Lex SDK available at https://github.com/mag1309/java-aws-lambda-lex-sdk.git. This SDK will be installed locally and configuration steps are provided in README file. This SDK is included in pom.xml.

Steps to run the program:

1. Clone this repository:  
   git clone https://github.com/mag1309/java-aws-lex-hellworld.git
   
2. Perform a Maven package to build the JAR files: 
   mvn clean package
   
   Created lex-hello-word-1.0.jar file will be uploaded manully to AWS Lambda service after creation of function.

3. Go to AWS Lambda(available on AWS Service List) and create a new function. You can give any name to function (i.e. HelloWord), select JDK8 as run time and choose default role to create new lambda function.

4. Go to Function Code section after function creation, choose upload zip/jar option, runtime as jdk8, provide handler as com.sample.chatbot.handlers.HelloHandler::handleRequest, choose lex-hello-word-1.0.jar created in step-2 from your computer and press "Save" button (top right corner). Wait for file upload. You can create Test cases also in Lambda console.

5. Now create ChatBot with AWS Lex. Go to Lex console and create a custom chatbot with 5-10 minute of session duration. You will create an Intent (name is Hello for example) with a slot name "fistname" to run the chatbot. 

6. After Intent save, Build and Test the bot.

7. Sample chat communication will be as below
   User  :  Hi
   Bot   :  What is your name ?
   User  :  Test
   Bot   :  Hello Test, How are you doing?
   
Mail me @mag1309@yahoo.com if you are not able to run the code.
