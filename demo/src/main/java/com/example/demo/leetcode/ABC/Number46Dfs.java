package com.example.demo.leetcode.ABC;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/6/30 17:02
 */
public class Number46Dfs {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    /**
     * @param nums
     * @param len
     * @param depth 深度
     * @param path
     * @param used  是否被使用
     * @param res
     */
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Number46Dfs number46Dfs = new Number46Dfs();
        int[] nums = {0, 1, 2};
        number46Dfs.permute(nums);
    }
}
