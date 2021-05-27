package com.example.demo.leetcode;

/**
 * @Author: wanglong
 * @Date: 2021/5/24 18:06
 */
public class AAA {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        AAA aaa = new AAA();
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        aaa.maxSubArray(array);
    }
}
