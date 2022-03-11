package com.zms.learn.config;

import com.zms.learn.util.ThreadMdcUtil;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class ScheduleConfig {

    @Bean("schedule")
    public Executor myAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor() {
            @Override
            public <T> Future<T> submit(Callable<T> task) {
                // 传入线程池之前先复制当前线程的MDC
                return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
            }

            @Override
            public void execute(Runnable task) {
                super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
            }
        };
        //最大线程数
        executor.setMaxPoolSize(100);
        //核心线程数
        executor.setCorePoolSize(10);
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
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //线程初始化
        executor.initialize();
        return executor;
    }
}
