package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/9 11:04
 */
public class Number66 {
    //通不过,给的是字符串会超长
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < digits.length; k++) {
            sb.append(digits[k]);
        }

        long i = Long.parseLong(sb.toString());
        String s1 = String.valueOf(i + 1);
        char[] chars = s1.toCharArray();
        int[] toInt = new int[chars.length];
        for (int j = 0; j < chars.length; j++) {
            toInt[j] = Integer.parseInt(String.valueOf(chars[j]));
        }
        return toInt;
    }

    public static void main(String[] args) {
        Number66 number66 = new Number66();
        int[] ints = {9,8,7,6,5,4,3,2,1,0};
        int[] ints1 = number66.plusOne(ints);
        System.out.println(Arrays.toString(ints1));
    }
}
