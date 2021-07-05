package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * @Author: wanglong
 * @Date: 2021/6/25 11:02
 */
public class Number496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 5, 2, 4};
        int[] num2 = {6, 5, 4, 3, 7, 2, 1};
//        int[] num2 = {6, 5, 4, 3, 2, 1, 7};
//        int[] num1 = {4, 1, 2};
//        int[] num2 = {1, 3, 4, 2};
//        int[] num1 = {2, 4};
//        int[] num2 = {1, 2, 3, 4};
        Number496 number496 = new Number496();
        int[] ints = number496.nextGreaterElement(num1, num2);
        System.out.println(Arrays.toString(ints));
    }
}
