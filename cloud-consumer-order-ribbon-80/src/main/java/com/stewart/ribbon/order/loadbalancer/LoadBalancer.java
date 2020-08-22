package com.stewart.ribbon.order.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自己实现轮询算法
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
