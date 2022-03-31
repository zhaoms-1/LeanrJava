package com.zms.learn.service.message.impl;

import com.zms.learn.modle.bo.message.BaseMessage;
import com.zms.learn.service.message.ReceiveMessage;

/**
 * 消息责任链模式
 */
public abstract class AbstractInboundBaseReceiveMessage implements ReceiveMessage {

    public abstract void onMessage(BaseMessage message);

    public abstract String getStation();
}
