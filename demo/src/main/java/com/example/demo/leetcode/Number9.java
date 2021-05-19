package com.example.demo.leetcode;

/**
 * 回文数
 *
 * @Author: wanglong
 * @Date: 2021/5/19 10:54
 */
public class Number9 {
    public boolean isPalindrome(int x) {
        //负数肯定不可能是回文数
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        String s1 = new StringBuffer(s).reverse().toString();

        return s1.equals(s);
    }
}
