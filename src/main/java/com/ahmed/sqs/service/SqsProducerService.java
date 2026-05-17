package com.ahmed.sqs.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsProducerService {

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queueUrl}")
    private String queueUrl;

    public SqsProducerService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    public void sendMessage(String message) {

        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build();

        sqsClient.sendMessage(request);

        System.out.println("Message Sent Successfully");
    }
}
