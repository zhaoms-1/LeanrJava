package com.zms.learn.service.impl;

import com.zms.learn.service.ReceiveMessage;

public abstract class AbstractInboundBaseReceiveMessage implements ReceiveMessage {

    public abstract void onMessage();

    public abstract String getStation();
}
