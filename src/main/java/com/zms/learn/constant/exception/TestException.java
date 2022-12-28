package com.zms.learn.constant.exception;

import com.zms.learn.constant.enums.ExceptionCodeEnum;
import org.apache.commons.lang3.StringUtils;

public class TestException extends RuntimeException {
    /**
     * 错误码
     */
    protected Integer errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public TestException() {
        super();
    }

    public TestException(String msg) {
        super(msg);
    }

    public TestException(ExceptionCodeEnum exceptionEnum) {
        super(exceptionEnum.getExceptionCode() + StringUtils.SPACE + exceptionEnum.getExceptionMsg());
        this.errorCode = exceptionEnum.getExceptionCode();
        this.errorMsg = exceptionEnum.getExceptionMsg();
    }

}
