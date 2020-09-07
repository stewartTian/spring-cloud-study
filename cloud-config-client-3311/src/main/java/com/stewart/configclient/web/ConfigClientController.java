package com.stewart.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @RefreshScope 参数动态刷新
 *      需要通过post请求刷新  curl -X POST “http://localhost:3311/actuator/refresh”
 */
@RefreshScope
@RestController
@RequestMapping("/config/client")
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/info")
    public String getInfo(){
        return info;
    }

}
