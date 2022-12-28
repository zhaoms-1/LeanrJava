package com.zms.learn.config;

import com.zms.learn.constant.enums.ExceptionCodeEnum;
import com.zms.learn.modle.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Response exception(Exception e) {
        log.error("未知异常：", e);
        return Response.error(ExceptionCodeEnum.ERROR);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Response exception(RuntimeException e) {
        log.error("业务异常：", e);
        return Response.error(ExceptionCodeEnum.INSERT_ERROR);
    }
}
