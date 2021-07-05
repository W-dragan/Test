package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * <p>
 * <p>
 * 对于每一个形如 A[i] = v 的元素，我们将其索引 i 按照对应值 v 排序之后的顺序写下。
 * 例如， A[0] = 7, A[1] = 2, A[2] = 5, A[3] = 4，
 * 我们应该这样顺序写下索引值 i=1, i=3, i=2, i=0。
 * <p>
 * 然后，当我们写下一个索引 i 的时候，我们可以得到候选的宽度答案 i - min(indexes_previously_written) （如果这个值是正数的话）。
 * 我们可以用一个变量 m 记录已经写下的最小索引。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/25 17:04
 */
public class Number962 {
    /**
     * 找到最长的单调递减数列,最远距离则是之后某个数在这个范围之间
     *
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {
        int length = nums.length;
        Integer[] B = new Integer[length];
        for (int i = 0; i < length; ++i) {
            B[i] = i;
        }
        //b为数组由小到大排序索引的值
        Arrays.sort(B, Comparator.comparingInt(i -> nums[i]));

        int ansMax = 0;
        int currMin = length;
        for (int i : B) {
            //当前索引值减去之前最小的则是最大的,类似于滑动窗口
            ansMax = Math.max(ansMax, i - currMin);
            //索引最小值
            currMin = Math.min(currMin, i);
        }

        return ansMax;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        Number962 number962 = new Number962();
        int i = number962.maxWidthRamp(nums);
        System.out.println(i);
    }

}
