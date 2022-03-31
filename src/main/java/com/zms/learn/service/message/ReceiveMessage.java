package com.zms.learn.service.message;

import com.zms.learn.modle.bo.message.BaseMessage;

public interface ReceiveMessage {
    void onMessage(BaseMessage message);

    String getStation();
}
