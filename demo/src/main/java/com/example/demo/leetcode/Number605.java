package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/22 11:25
 */
public class Number605 {
    /**
     * 1.此处为0,且前后为0,可以种花
     * 2 首尾特殊处理
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int times = 0;
        int length = flowerbed.length;
        int[] ints = new int[length + 2];
        System.arraycopy(flowerbed, 0, ints, 1, length);
        for (int i = 1; i < ints.length - 1; i++) {
            if (ints[i] == 0 && ints[i - 1] == 0 && ints[i + 1] == 0) {
                ints[i] = 1;
                times++;
            }
        }
        return times >= n;
    }

    public static void main(String[] args) {
        Number605 number605 = new Number605();
        int[] nums = {0, 0, 1, 0, 1};
        boolean b = number605.canPlaceFlowers(nums, 1);
        System.out.println(b);
    }
}
