package com.zms.learn.service.impl;

import com.zms.learn.service.AStation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AStationImpl extends AbstractInboundBaseReceiveMessage implements AStation {
    @Override
    public void onMessage() {

    }

    @Override
    public String getStation() {
        return null;
    }
}
