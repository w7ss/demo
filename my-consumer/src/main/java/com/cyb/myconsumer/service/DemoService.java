package com.cyb.myconsumer.service;

import com.cyb.myconsumer.bean.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBack")
    public Object consume(){
        return restTemplate.getForEntity("http://my-service/myservice/demo/get", Person.class);
    }

    private Object fallBack(){
        return "timeout";
    }
}
