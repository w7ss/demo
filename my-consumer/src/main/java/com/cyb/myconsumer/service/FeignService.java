package com.cyb.myconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "my-service")
public interface FeignService {

    @GetMapping("/myservice/demo/get")
    public Object consume();
}
