package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 *
 * @Author: wanglong
 * @Date: 2021/5/18 14:37
 */
public class Number5 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] num3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num3, 0, nums1.length);
        System.arraycopy(nums2, 0, num3, nums1.length, nums2.length);
        Arrays.sort(num3);
        if (num3.length % 2 == 1) {
            return num3[num3.length / 2];
        } else {
            return (double) (num3[(num3.length + 1) / 2] + num3[(num3.length + 1) / 2 - 1]) / 2;

        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1};
        findMedianSortedArrays(num1, num2);
    }
}
