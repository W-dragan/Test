package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 电话号码的字母组合
 *
 * @Author: wanglong
 * @Date: 2021/5/20 16:54
 */
public class Number17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            sb.append(phoneMap.get(digits.charAt(i)));
        }
//        Queue<String> queue = new LinkedList<>();
        return combinations;

    }

    private void resolve(String digits, Map<Character, String> phoneMap, int index, StringBuilder sb, List<String> list) {
        if (digits.length() == index) {
            return;
        }
        char c = digits.charAt(index);
        String s = phoneMap.get(c);
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }
        index++;
    }

    public static void main(String[] args) {
        Number17 number17 = new Number17();
        List<String> list = number17.letterCombinations("34");
        System.out.println(list.toString());
    }
}
