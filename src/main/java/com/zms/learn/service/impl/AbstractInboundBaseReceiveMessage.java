package com.zms.learn.service.impl;

import com.zms.learn.modle.bo.message.BaseMessage;
import com.zms.learn.service.ReceiveMessage;


public abstract class AbstractInboundBaseReceiveMessage implements ReceiveMessage {

    public abstract void onMessage(BaseMessage message);

    public abstract String getStation();
}
