package com.zms.learn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

@Configuration
@Slf4j
public class ScheduleConfig {

    private AtomicBoolean tag = new AtomicBoolean(false);


    @Bean("schedule")
    @Primary
    public Executor async() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //最大线程数
        executor.setMaxPoolSize(50);
        //核心线程数
        executor.setCorePoolSize(5);
        //任务队列的大小
        executor.setQueueCapacity(10);
        //线程前缀名
        executor.setThreadNamePrefix("schedule-");
        //线程存活时间
        executor.setKeepAliveSeconds(30);

        /**
         * 拒绝处理策略
         * CallerRunsPolicy()：交由调用方线程运行，比如 main 线程。
         * AbortPolicy()：直接抛出异常。
         * DiscardPolicy()：直接丢弃。
         * DiscardOldestPolicy()：丢弃队列中最老的任务。
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                // 防止频繁输出日志
                if (tag.compareAndExchange(false, true)) {
                    log.warn("The thread pool is schedule full");
                    throw new RejectedExecutionException("Task " + r.toString() +
                            " rejected from " +
                            e.toString());
                }
            }
        });
        //线程初始化
        return executor;
    }
}
