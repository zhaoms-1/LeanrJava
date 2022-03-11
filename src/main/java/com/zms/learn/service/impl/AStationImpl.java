package com.zms.learn.service.impl;

import com.zms.learn.modle.bo.message.BaseMessage;
import com.zms.learn.modle.bo.message.CompleteMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AStationImpl extends AbstractInboundBaseReceiveMessage {

    @Override
    public void onMessage(BaseMessage message) {
        if (message instanceof CompleteMessage) {
            log.info("receive message:{}", message);
        }
    }


    @Override
    public String getStation() {
        return null;
    }
}
