package com.zms.learn.service.impl;

import com.zms.learn.service.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestImpl implements Test {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sayHello() {
        System.out.println("hello springboot");
    }
}
