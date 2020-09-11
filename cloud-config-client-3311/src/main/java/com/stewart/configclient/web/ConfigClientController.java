package com.stewart.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @RefreshScope 参数动态刷新
 *  未接入MQ需要Post请求指定服务节点refresh刷新变更参数
 *      需要通过post请求刷新  curl -X POST “http://localhost:3311/actuator/refresh”
 *
 *  接入MQ：向配置中心发Post请求即可
 *      全局更新： curl -X POST “http://localhost:3301/actuator/bus-refresh”
 *
 *      指定更新对应服务:   curl -X POST “http://localhost:3301/actuator/bus-refresh/cloud-config-client:3311”
 *                      curl -X POST “http://localhost:3301/actuator/bus-refresh/cloud-config-client:3312"
 *
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
