package com.zms.learn.constant.enums;

import lombok.Getter;

public enum ExceptionCodeEnum {
    SUCCESS(0, "成功"),

    INSERT_ERROR(10000001, "插入异常"),
    ERROR(90000099, "系统错误");

    @Getter
    private Integer exceptionCode;
    @Getter
    private String exceptionMsg;

    ExceptionCodeEnum(Integer exceptionCode, String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }
}
