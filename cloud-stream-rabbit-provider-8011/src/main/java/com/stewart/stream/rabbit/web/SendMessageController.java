package com.stewart.stream.rabbit.web;

import com.stewart.stream.rabbit.mq.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream/sender")
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        return messageProvider.send();
    }

}
