package com.zms.learn.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 */
public class RandomUtil {

    public static int getRandomUtil() {
        return ThreadLocalRandom.current().nextInt();
    }
}
