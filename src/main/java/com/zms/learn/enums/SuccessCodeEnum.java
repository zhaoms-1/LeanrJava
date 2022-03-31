package com.zms.learn.enums;

/**
 * 成功消息枚举定义
 */
public enum SuccessCodeEnum {
    SUCCESS(0, "成功");

    private int value;

    private String desc;

    SuccessCodeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
