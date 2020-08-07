package com.cyb.myconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MyConsumerApplication implements ErrorPageRegistrar {

    public static void main(String[] args) {
        SpringApplication.run(MyConsumerApplication.class, args);
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/demo/404.html"));
    }

    @Bean
    @LoadBalanced
    public RestTemplate RestTemplate(/*RestTemplateBuilder builder*/){
        //return builder.build();
        RestTemplate restTemplate=new RestTemplate();//使用spring默认实现SimpleClientHttpRequestFactory
        //RestTemplate restTemplate=new RestTemplate(new HttpComponentsClientHttpRequestFactory());//使用httpclient实现
        //RestTemplate restTemplate=new RestTemplate(new OkHttp3ClientHttpRequestFactory());//使用okhttp实现
        return restTemplate;
    }
}
