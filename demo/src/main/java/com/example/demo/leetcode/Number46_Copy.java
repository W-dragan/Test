package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @Author: wanglong
 * @Date: 2021/6/30 10:14
 */
public class Number46_Copy {
    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] flag = new boolean[nums.length];
        dfs(flag, res, path, nums);
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
                flag[i] = true;
                path.addLast(nums[i]);
                dfs(flag, res, path, nums);
                path.removeLast();
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Number46_Copy number46 = new Number46_Copy();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = number46.permute(nums);
        System.out.println(permute);
    }
}
