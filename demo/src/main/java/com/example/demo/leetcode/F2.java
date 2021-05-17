package com.example.demo.leetcode;

/**
 * @Author: wanglong
 * @Date: 2021/4/20 19:00
 */
public class F2 {
    public static int f(int[] nums, int target) {
        int[] t = new int[target + 1];
        t[0] = 1;
        for (int num : nums) {
            for (int j = num; j <= target; j++) {
                t[j] = t[j] + t[j - num];
            }
        }
        return t[target];
    }

    public static void main(String[] args) {
//        int[] test = new int[]{1, 18, 24, 48, 120, 240};
        int[] test = new int[]{1, 2, 3, 4, 5};
        int f = f(test, 7);
        System.out.println(f);

    }
}
