package com.cyb.demo.controller;

import com.cyb.demo.bean.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping(value = "/test")
    public Person test(){
        //throw new NullPointerException("空指针异常！");
        return new Person(1L,"lucy");
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
