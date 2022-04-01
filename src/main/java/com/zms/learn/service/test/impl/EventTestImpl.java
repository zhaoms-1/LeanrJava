package com.zms.learn.service.test.impl;

import com.zms.learn.modle.event.TaskSendEvent;
import com.zms.learn.service.test.EventTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventTestImpl implements EventTest {
    @EventListener(classes = TaskSendEvent.class)
    @Override
    public void eventTest(TaskSendEvent taskSendEvent) {
        log.debug("测试事件:{}", taskSendEvent.getEventDTO().getMsg());
        log.debug("测试事件:{}", taskSendEvent.getEventDTO().getStation());

    }
}
