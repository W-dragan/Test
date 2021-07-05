package com.example.demo.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1 包含重复数字的数组
 * 2 每个数字只能用一遍
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/7/1 15:30
 */
public class Number40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(res, 0, path, candidates, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, int begin, Deque<Integer> path, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(res, i + 1, path, candidates, target - candidates[i]);
            path.removeLast();

        }
    }

    public static void main(String[] args) {
//        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int[] nums = {1, 1, 1, 2, 3};
        Number40 number40 = new Number40();
        List<List<Integer>> list = number40.combinationSum2(nums, 5);
        System.out.println(list);
    }
}
