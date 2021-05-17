package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * @Author: wanglong
 * @Date: 2021/4/19 10:56
 */
public class DynamicPlanning {
    public static long dp(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 1; i < 18; i++) {
            dp[i] = 1;
        }
        dp[18] = 2;
        for (int j = 19; j <= 24; j++) {
            dp[j] = dp[18] + (j - 18);
        }
        //因为自己本身也是一种方案,所以需要+1
        dp[24] = dp[24] + 1;
        for (int k = 25; k <= 48; k++) {
            dp[k] = dp[k - 24] + dp[k - 12] + dp[k - 1];
        }
        dp[48] = dp[48] + 1;
        for (int a = 49; a <= 120; a++) {
            dp[a] = dp[a - 48] + dp[a - 24] + dp[a - 12] + dp[a - 1];
        }
        dp[120] = dp[120] + 1;
        for (int b = 120; b <= 240; b++) {
            dp[b] = dp[b - 120] + dp[b - 48] + dp[b - 24] + dp[b - 12] + dp[b - 1];
        }
        dp[240] = dp[240] + 1;
        System.out.println(Arrays.toString(dp));
        return dp[n];
//            for(int i = 3; i<=n;i++){
//                if(i<18){
//                    dp[i] = 1;
//                } else if(i > 18){
//                    dp[i] = dp[i-18] + dp[i-1];
//                }else if(i>24){
//
//                }
//                dp[i] = dp[i-120] + dp[i-48] + dp[i-24] + dp[i-18];
//            }
    }

    public static void main(String[] args) {
        long resolve = dp(240);
        System.out.println(resolve);
    }
//    public static int fibonacci(int n) {
//        if (n < 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if(n == 18){
//            return 2;
//        }
//        return fibonacci(n-240) + fibonacci(n - 120) + fibonacci(n - 48) + fibonacci(n - 24) + fibonacci(n - 18) + fibonacci(n - 1);
//    }

    public static int resolve(int n) {
        System.out.println("进来的是：{}" + n);
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n <= 18) {
            return 2;
        }

        return resolve(n - 120) + resolve(n - 48) + resolve(n - 24) + resolve(n - 18) + resolve(n - 1);
    }


}
