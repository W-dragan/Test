package com.example.demo.leetcode;

import com.google.errorprone.annotations.Var;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *
 * @Author: wanglong
 * @Date: 2021/5/31 16:47
 */
public class Number22 {
    private String left = "(";
    private String right = ")";

    public List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        resolve(new char[n * 2], 0, res);
        return res;
    }

    private void resolve(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            current[pos] = left.charAt(0);
            resolve(current, pos + 1, result);
            current[pos] = right.charAt(0);
            resolve(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        Number22 number22 = new Number22();
        List<String> list = number22.generateParentheses(3);
        System.out.println(list);
    }
}
