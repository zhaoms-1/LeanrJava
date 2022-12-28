package com.zms.learn.service;

import com.zms.learn.constant.enums.ExceptionCodeEnum;
import com.zms.learn.constant.exception.TestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExceptionTest {

    @Test
    void exceptionTest() {
        try {
            throw new TestException(ExceptionCodeEnum.ERROR);
        } catch (TestException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
