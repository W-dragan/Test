package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @Author: wanglong
 * @Date: 2021/6/30 20:45
 */
public class Number39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, res, target, candidates, path);
        return res;
    }

    private void dfs(int now, List<List<Integer>> res, int target, int[] candidates, Deque<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = now; i < candidates.length; i++) {

            path.addLast(candidates[i]);
            dfs(i, res, target - candidates[i], candidates, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Number39 number39 = new Number39();
        int[] nums = {2, 3, 5};
        List<List<Integer>> list = number39.combinationSum(nums, 8);
        System.out.println(list);
    }
}
