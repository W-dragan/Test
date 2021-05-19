package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/5/18 19:44
 */
public class Number15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        boolean flag = false;
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            int num1 = nums[i + 1];
            for (int j = i + 2; j < nums.length; j++) {
                if (num == num1 && num == nums[j] && num == 0 && flag) {
                    continue;
                }
                if (-num == num1 + nums[j]) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(num);
                    integerList.add(num1);
                    integerList.add(nums[j]);
                    list.add(integerList);
                }
                if (num == num1 && num == nums[j] && num == 0) {
                    flag = true;
                }
            }
        }
        return list;
    }
    //-4, -1, -1, 0, 1, 2,
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                return list;
            }
            //-a=b+c,这步操作是为了防止a因子重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int temp = curr + nums[L] + nums[R];
                if (temp == 0) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(curr);
                    integerList.add(nums[L]);
                    integerList.add(nums[R]);
                    list.add(integerList);
                    //-a=b+c,下面两步操作是为了防止b,c因子重复
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (temp > 0) {
                    R--;
                } else {
                    L++;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        int[] nums = new int[]{0, 0, 0, 0};
//        int[] nums = new int[]{-2, 0, 1, 1, 2};
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum1(nums);
        System.out.println(list);
    }
}
