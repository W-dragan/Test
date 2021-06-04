package com.example.demo.leetcode;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4`x
 *
 * @Author: wanglong
 * @Date: 2021/5/31 15:17
 */
public class Number342 {
    public boolean isPowerOfFour(int n) {
        if (n == 1 ) {
            return true;
        }
        if (n / 4 == 1 && n % 4 == 0) {
            return true;
        }
        if (n % 4 == 0 && n / 4 >= 1) {
            return isPowerOfFour(n / 4);
        }
        return false;
    }

    public static void main(String[] args) {
        Number342 number342 = new Number342();
        boolean powerOfFour = number342.isPowerOfFour(1);
        System.out.println(powerOfFour);
    }
}
