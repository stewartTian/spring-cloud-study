package com.stewart.stream.rabbit.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("Stream消费者" + port + " 接受消息 receive : " + payload);
    }

}
