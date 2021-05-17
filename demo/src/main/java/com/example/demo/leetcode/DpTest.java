package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数和数组,求这个整数可以由数组中的数字的多种组成方式
 * @Author: wanglong
 * @Date: 2021/4/20 18:38
 */
public class DpTest {
    public static int f(int[] nums, int target) {
        int[] t;
        t = new int[target + 1];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[0] = 0;
        for (int num : nums) {
            for (int j = num; j <= target; j++) {
                if (t[j - num] != Integer.MAX_VALUE) {
                    t[j] = Math.min(t[j], t[j - num] + 1);
                }
            }
        }
        return t[target] == Integer.MAX_VALUE ? -1 : t[target];
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 3};
        int f = f(test, 4);
        System.out.println(f);
    }
}
