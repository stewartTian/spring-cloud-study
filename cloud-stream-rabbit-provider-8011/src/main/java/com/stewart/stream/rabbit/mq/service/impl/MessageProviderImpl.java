package com.stewart.stream.rabbit.mq.service.impl;

import com.stewart.stream.rabbit.mq.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    @Qualifier("output")
    private MessageChannel channel;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        channel.send(MessageBuilder.withPayload(serial).build());
        System.out.println("Stream生产者 发送serial : " + serial);
        return serial;
    }

}
