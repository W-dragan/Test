package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 可以设计时间复杂度为O(n)的情况吗
 *
 * @Author: wanglong
 * @Date: 2021/7/5 10:35
 */
public class Number128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        Object[] objects = set.toArray();
        int[] result = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            result[i] = (int) objects[i];
        }
        Arrays.sort(result);

        int res = 1;
        int max = 1;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == result[i - 1] + 1) {
                res++;
                max = Math.max(max, res);
            } else {
                res = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Number128 number128 = new Number128();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int i = number128.longestConsecutive(nums);
        System.out.println(i);
    }
}
