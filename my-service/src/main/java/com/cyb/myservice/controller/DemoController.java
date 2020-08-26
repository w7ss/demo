package com.cyb.myservice.controller;

import com.cyb.myservice.bean.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping(value = "/get")
    public Person pullPerson() throws InterruptedException {
        //throw new NullPointerException("空指针异常！");
        System.out.println("I'm chosen");
        Thread.sleep(4000);
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
}
