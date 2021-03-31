package com.example.Microservice2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class hello {
    @HystrixCommand(fallbackMethod = "defaultMessage")
    @GetMapping("/")
    public String hello() throws Exception {
        return "hello world";
       // throw new Exception();
    }
    public String defaultMessage() {
        return "hola que tal";
    }
}
