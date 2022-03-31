package com.zms.learn.controller;

import com.zms.learn.modle.Response;
import com.zms.learn.modle.dto.EventDTO;
import com.zms.learn.modle.event.TaskSendEvent;
import com.zms.learn.service.test.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private Test test;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping("/test")
    void Test() {
        test.sayHello();
    }

    @GetMapping("/test/event")
    Response eventTest() {
        TaskSendEvent taskSendEvent = new TaskSendEvent(this, new EventDTO());
        applicationEventPublisher.publishEvent(taskSendEvent);
        return Response.succ();
    }
}
