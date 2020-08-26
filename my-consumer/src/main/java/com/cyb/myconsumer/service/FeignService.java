package com.cyb.myconsumer.service;

import com.cyb.myconsumer.service.hystrix.FeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "my-service", fallback = FeignServiceHystrix.class)
public interface FeignService {

    @GetMapping("/myservice/demo/get")
    public Object consume();
}
