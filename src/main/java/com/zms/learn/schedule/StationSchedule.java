package com.zms.learn.schedule;

import com.zms.learn.constant.enums.MessageEnum;
import com.zms.learn.modle.bo.message.CompleteMessage;
import com.zms.learn.service.message.ReceiveMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StationSchedule {
    @Resource
    private ReceiveMessage receiveMessage;

    /**
     * 1分钟执行一次
     */
    @Scheduled(fixedRate = 1000 * 5)
    @Async("schedule")
    void sendMessage() {
        CompleteMessage message = CompleteMessage.builder()
                .requestId("111")
                .station("A")
                .type(MessageEnum.BoxLineMessage)
                .container("test")
                .build();


        switch (message.getType()) {
            case BoxLineMessage:
                receiveMessage.onMessage(message);
        }
    }
}
