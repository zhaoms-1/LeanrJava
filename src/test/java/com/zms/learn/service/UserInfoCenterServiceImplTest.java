package com.zms.learn.service;

import com.zms.learn.service.user.UserInfoCenterService;
import com.zms.learn.service.user.impl.PassportServiceImpl;
import com.zms.learn.service.user.impl.UserInfoCenterServiceImpl;
import com.zms.learn.service.user.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootTest
@Import({UserInfoCenterServiceImpl.class})
public class UserInfoCenterServiceImplTest {
    @Autowired
    private UserInfoCenterService userInfoCenterService;

    @Test
    void test() {
        List userInfoById = null;
        try {
            userInfoById = userInfoCenterService.getUserInfoById(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("输出：" + userInfoById);
    }

}
