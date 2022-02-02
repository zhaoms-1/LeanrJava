package com.zms.learn.controller;

import com.zms.learn.service.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private Test test;

    @GetMapping("/test")
    void Test() {
        test.sayHello();
    }
}
