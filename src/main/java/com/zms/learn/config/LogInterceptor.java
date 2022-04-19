package com.zms.learn.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    public static final String TRACE_ID = "traceId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            MDC.put(TRACE_ID, UUID.randomUUID().toString().replace("-", ""));
        } else {
            MDC.put(TRACE_ID, traceId);
        }
        return true;
    }

}
