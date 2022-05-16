package com.zms.learn.service.user.impl;

import com.zms.learn.service.user.UserInfoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public String getUser() {
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(Thread.currentThread() + ":Bob");
        return "Bob";
    }

    @Override
    public String getSchool() {
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread() + ":new school");
        return "new School";
    }
}
