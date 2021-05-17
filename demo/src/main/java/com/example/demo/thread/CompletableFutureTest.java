package com.example.demo.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: wanglong
 * @Date: 2021/5/15 10:17
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return querySleepCode("中国石油", "https://money.163.com/code/");
        });
        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<String> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query " + name + "code from " + url + "...");
//        try {
//            Thread.sleep((long) (Math.random() * 100));
//        } catch (InterruptedException e) {
//        }
        return "601857" + url;
    }
    static String querySleepCode(String name, String url) {
        System.out.println("query " + name + "code from " + url + "...");
        try {
            System.out.println("进入等待前");
            Thread.sleep(50000000);
        } catch (InterruptedException e) {
        }
        System.out.println("等待结束");
        return "000000" + url;
    }
    static String fetchPrice(String code, String url) {
        System.out.println("query " + code + "price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return code + url;
    }
}
