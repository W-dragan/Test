package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * @Author: wanglong
 * @Date: 2021/5/18 16:43
 */
public class Number88 {
    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int j = 0;
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            if (j == m || k == n) {
                break;
            }
            int i1 = nums1[j];
            int i2 = nums2[k];
            if (i1 >= i2) {
                result[i] = i2;
                k++;
            } else {
                result[i] = i1;
                j++;
            }
        }
        if (j == m) {
            System.arraycopy(nums2, k, result, j+1, n-k);
        }
        if (k == n) {
            System.arraycopy(nums1, j, result, k+1, m-j);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = new int[]{2, 5, 6};
        int n = 3;
        int[] merge = merge(num1, m, num2, n);
        System.out.println(Arrays.toString(merge));
    }
}
