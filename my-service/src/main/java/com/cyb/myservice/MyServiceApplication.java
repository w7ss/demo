package com.cyb.myservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class MyServiceApplication implements ErrorPageRegistrar {

    public static void main(String[] args) {
        SpringApplication.run(MyServiceApplication.class, args);
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/demo/404.html"));
    }
}
