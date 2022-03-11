package com.zms.learn.service;

public interface ReceiveMessage {
    void onMessage();

    String getStation();
}
