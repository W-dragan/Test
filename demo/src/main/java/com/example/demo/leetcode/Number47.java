package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @Author: wanglong
 * @Date: 2021/7/2 15:01
 */
public class Number47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] flag = new boolean[nums.length];
        dfs(flag, res, path, nums);
//        List<String> list = new ArrayList<>();
//        res.forEach(r -> {
//            StringBuilder sb = new StringBuilder();
//            r.forEach(sb::append);
//            list.add(sb.toString());
//        });
//        List<String> collect = list.stream().distinct().collect(Collectors.toList());
//        res.clear();
//        collect.forEach(c -> {
//            char[] chars = c.toCharArray();
//            List<Integer> list1 = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++) {
//                list1.add(Integer.parseInt(String.valueOf(chars[i])));
//            }
//            res.add(list1);
//        });
        return res;
    }

    private void dfs(boolean[] flag, List<List<Integer>> res, Deque<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (flag[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                    continue;
                }
                flag[i] = true;
                path.addLast(nums[i]);
                dfs(flag, res, path, nums);
                path.removeLast();
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Number47 number47 = new Number47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = number47.permuteUnique(nums);
        System.out.println(list);
    }
}
