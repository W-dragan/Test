package com.example.demo.thread;

import com.example.demo.leetcode.A;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.omg.PortableServer.ThreadPolicy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanglong
 * @Date: 2021/5/17 16:51
 */
public class TestMain {
    public static void main(String[] args) {
//编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
        OrderPrint service = new OrderPrint();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor cacheThreadPool = new ThreadPoolExecutor(
                10,
                100,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(true),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
        cacheThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                service.printA();
            }
        });
        cacheThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                service.printB();
            }
        });
        cacheThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                service.printC();
            }
        });
        cacheThreadPool.shutdown();
    }
}
