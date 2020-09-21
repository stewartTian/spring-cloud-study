package com.stewart.zipkin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipkin/consumer")
public class ZipkinConsumerController {

    @GetMapping("/provider")
    public String zipkin(){
        return null;
    }

}
