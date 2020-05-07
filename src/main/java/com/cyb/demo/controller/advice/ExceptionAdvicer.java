package com.cyb.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *异常处理
 * @author cyb
 * @date 2020-05-07
 **/
@RestControllerAdvice(basePackages = "com.cyb.demo.controller")
public class ExceptionAdvicer {

    @ExceptionHandler(value = {NullPointerException.class/*, IllegalAccessException.class, IllegalStateException.class*/})
    public Object handleNPE(Throwable throwable) {
        Map<String,Object> exception = new HashMap<>();
        exception.put("message",throwable.getMessage());
        return exception;
    }

}
