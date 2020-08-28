package com.cyb.myconsumer.service.hystrix;

import com.cyb.myconsumer.service.FeignService;
import org.springframework.stereotype.Service;

@Service
public class FeignServiceHystrix implements FeignService {
    @Override
    public Object consume() {
        return "timeout";
    }
}
