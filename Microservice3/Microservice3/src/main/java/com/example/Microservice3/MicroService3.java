package com.example.Microservice3;

import com.google.common.util.concurrent.Service;
import com.netflix.ribbon.Ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroService3 {
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/")
    public void method() {
        ServiceInstance serviceInstance = loadBalancer.choose("name-of-the-microservice2");

        System.out.println(serviceInstance.getUri());
    }



}
