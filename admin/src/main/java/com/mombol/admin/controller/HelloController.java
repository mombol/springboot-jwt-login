package com.mombol.admin.controller;

import com.mombol.common.exception.MombolBindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Welcome to admin!";
    }

    @GetMapping("/custom-exception")
    public void customException() throws MombolBindException {
        throw new MombolBindException("抛出自定义异常信息");
    }

}
