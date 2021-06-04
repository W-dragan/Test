package com.example.demo.leetcode;

/**
 * @Author: wanglong
 * @Date: 2021/5/27 17:37
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int length = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum = sum + num;
            right++;
            if (sum >= target) {
                if(length == 0){
                    length = right - left;
                }else {
                    length = Math.min(length, right - left);
                }
                while ((sum - nums[left]) >= target) {
                    sum = sum - nums[left];
                    left++;
                    length = Math.min(length, right - left);
                }
            }
        }
        return length;
    }

    /**
     * 队列
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Number209 number209 = new Number209();
//        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        int[] arr = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int i = number209.minSubArrayLen(155, arr);
        System.out.println(i);
    }
}
