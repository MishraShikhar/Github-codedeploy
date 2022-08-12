package com.helloworld;
import java.util.logging.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
public class myError {
    // private constructor to avoid instantiation
    private myError(){}
    private static myError myError = null;
    private static String ACCESS_KEY = "";
    private static String SECERET_KEY = "";
    static AWSCredentials aac;
    static AmazonDynamoDB ddb;
    public synchronized static myError getInstance() {
        if (myError == null) {
            myError = new Credentials();
            try {
                aac = new BasicAWSCredentials(ACCESS_KEY, SECERET_KEY);

                ddb= AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").withCredentials(new AWSStaticCredentialsProvider(aac) ).build();
            } catch (final Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Hiding the exception");
            }
            
        }
        return myError;
    }
}
