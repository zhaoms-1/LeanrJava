package com.zms.learn.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
public class RandomTest {
    @DisplayName("随机数测试")
    @Test
    void randomTest() {

        for (int time = 0; time < 100; time++) {
            int i = ThreadLocalRandom.current().nextInt(10, 99);
            System.out.println("随机数：" + i);
        }
    }



}


