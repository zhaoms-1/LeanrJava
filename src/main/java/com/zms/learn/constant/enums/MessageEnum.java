package com.zms.learn.constant.enums;

import lombok.Getter;

public enum MessageEnum {
    CompleteMessage(1, "任务完成消息"),
    BoxLineMessage(2, "箱线消息"),
    PalletMessage(3, "托盘线消息");


    @Getter
    private int type;
    @Getter
    private String msg;

    MessageEnum(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
