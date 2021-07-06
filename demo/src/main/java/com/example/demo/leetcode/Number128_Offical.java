package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wanglong
 * @Date: 2021/7/5 14:02
 */
public class Number128_Offical {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            //先找比当前数字小一的是否存在,不存在才进行计算,如果存在说明还有更小的,继续寻找下一个满足条件的
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Number128_Offical number128_offical = new Number128_Offical();
        int[] nums = {2,3,1,7,8};
        int i = number128_offical.longestConsecutive(nums);
        System.out.println(i);
    }
}
