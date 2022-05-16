package com.zms.learn.service.user.impl;

import com.zms.learn.service.user.PassportService;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements PassportService {
    @Override
    public String getPassport()  {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread() + "passport");
        return "passport";
    }
}
