package com.cyb.demo.controller;

import com.cyb.demo.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping(value = "/test")
    public Person test(){
        return new Person(1l,"lucy");
    }
}
