package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @Author: wanglong
 * @Date: 2021/7/2 17:00
 */
public class Number78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Collections.emptyList());
        for (int num : nums) {
            List<List<Integer>> subSets = new ArrayList<>();
            for (List<Integer> sub : ans) {
                List<Integer> subSet = new ArrayList<>(sub);
                subSet.add(num);
                subSets.add(subSet);
            }
            ans.addAll(subSets);
        }
        return ans;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        //<<左移运算符1<<2表示2的2次方
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                //&按位与,只有两个数字相同位数都为1,该位置才为1
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) {
                    t.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        Number78 number78 = new Number78();
        int[] nums = {1, 2, 3};
//        List<List<Integer>> subsets = number78.subsets(nums);
//        System.out.println(subsets);
        List<List<Integer>> list = number78.subsets2(nums);
        System.out.println(list);
        System.out.println(4>>1);
    }


}
