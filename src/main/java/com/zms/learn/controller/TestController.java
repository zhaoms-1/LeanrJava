package com.zms.learn.controller;

import com.zms.learn.enums.ExceptionCodeEnum;
import com.zms.learn.exception.TestException;
import com.zms.learn.modle.Response;
import com.zms.learn.modle.dto.EventDTO;
import com.zms.learn.modle.dto.TestDTO;
import com.zms.learn.modle.event.TaskSendEvent;
import com.zms.learn.service.test.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {
    @Resource
    private Test test;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping("/test")
    Response healthCheck() {
        return Response.succ();
    }

    @GetMapping("/test/event")
    Response eventTest() {
        TaskSendEvent taskSendEvent = new TaskSendEvent(this, EventDTO.builder().msg("test").station("station_a").build());
        applicationEventPublisher.publishEvent(taskSendEvent);
        return Response.succ();
    }

    @PostMapping("/check")
    Response dataCheck(@RequestBody TestDTO testDTO) {
        log.info("dataCheck:{}", testDTO);
        return Response.succ(testDTO);
    }

    @GetMapping("/exception")
    Response testException(@RequestParam int i) {
        if (i == 1) {
            throw new TestException(ExceptionCodeEnum.INSERT_ERROR);
        }
        int z = 1 / 0;
        return Response.succ();
    }

}
