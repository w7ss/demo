package com.cyb.myconsumer.controller;

import com.cyb.myconsumer.bean.Person;
import com.cyb.myconsumer.service.DemoService;
import com.cyb.myconsumer.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@RestController
//@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private DemoService ds;
    @Autowired
    private FeignService fs;

    @GetMapping(value = "/get")
    public Person pullPerson(){
        //throw new NullPointerException("空指针异常！");
        return new Person(1L,"lucy","dfh369");
    }

    @PostMapping(value = "/set")
    public void pushPerson(@Valid @RequestBody Person p){
        System.out.println(p.getName());
        System.out.println(p.getCode());
    }

    /**
     * 处理页面找不到的情况
     * @param status
     * @param request
     * @param throwable
     * @return
     *
     */
    @GetMapping("/404.html")
    public Map<String,Object> handlePageNotFound(HttpStatus status, HttpServletRequest request, Throwable throwable) {

        Map<String,Object> errors = new HashMap<>();
        errors.put("statusCode",
                request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri",
                request.getAttribute("javax.servlet.error.request_uri"));
        errors.put("message","页面找不到了！");

        return errors;
    }

    @GetMapping(value = "/consume")
    public Object consume(){
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("my-service");
        for(ServiceInstance instance:serviceInstances){
            System.out.println(instance.getUri());
        }

        return ds.consume();
    }

    @GetMapping(value = "/consumeByFeign")
    public Object consumeByFeign(){
        return fs.consume();
    }
}
