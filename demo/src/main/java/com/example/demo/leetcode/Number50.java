package com.example.demo.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 递归会爆栈
 *
 * @Author: wanglong
 * @Date: 2021/6/1 11:02
 */
public class Number50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return resolve(x * x, x, n - 1);
        } else {
            return resolveNavigate(x * x, x, n + 1);
        }

    }

    public double resolve(double result, double x, int n) {
        if (n == 1) {
            return result;
        }
        return resolve(result * x, x, n - 1);
    }
    public double resolveNavigate(double result, double x, int n) {
        if (n == -1) {
            return 1/result;
        }
        return resolve(result * x, x, n + 1);
    }

    public static void main(String[] args) {
        Number50 number50 = new Number50();
        double v = number50.myPow(2, -2);
        System.out.println(v);
    }
}
