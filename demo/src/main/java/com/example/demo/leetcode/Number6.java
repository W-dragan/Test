package com.example.demo.leetcode;

/**
 * @Author: wanglong
 * @Date: 2021/5/19 15:25
 */
public class Number6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows == 1) {
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        int dir = 1, index = 0;

        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }
        for (char c : s.toCharArray()) {
            array[index].append(c);
            index = index + dir;
            if (index == numRows - 1 || index == 0) {
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Number6 number6 = new Number6();
        String paypalishiring = number6.convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }
}
