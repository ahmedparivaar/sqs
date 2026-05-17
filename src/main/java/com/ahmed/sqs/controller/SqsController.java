package com.ahmed.sqs.controller;


import com.ahmed.sqs.service.SqsProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class SqsController {

    private final SqsProducerService producerService;

    public SqsController(SqsProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {

        producerService.sendMessage(message);

        return "Message sent to SQS";
    }
}
