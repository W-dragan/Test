package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: wanglong
 * @Date: 2021/6/23 20:35
 */
public class Number767Copy {
    /**
     * 根据出现次数由大到小排序,然后先填出现次数最多的
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> out = new LinkedHashMap<>();
        //组装map
        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.getOrDefault(chars[i], 0);
            if (integer == 0) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        char[] chars1 = new char[s.length()];
        map.entrySet().stream()
                //按大小排序
                .sorted((p1, p2) -> p2.getValue() - p1.getValue())
                .forEach(entry -> out.put(entry.getKey(), entry.getValue()));
        int k = 0;
        //是否奇数
        boolean isOdd = true;
        for (Map.Entry<Character, Integer> entry : out.entrySet()) {
            Integer value = entry.getValue();
            //数量乘2大于长度,说明怎么都不能填
            if (value * 2 > s.length() + 1) {
                return "";
            }
            Character key = entry.getKey();
            //一个萝卜一个坑,先填第0个
            for (int i = 0; i < value; i++) {
                chars1[k] = key;
                k = k + 2;
                if (k > s.length()) {
                    k = k - s.length();
                    isOdd = !isOdd;
                }
                if (k == s.length()) {
                    k = 1;
                    isOdd = !isOdd;
                }
            }
        }
        return String.valueOf(chars1);
    }

    public static void main(String[] args) {
        Number767Copy number767_copy = new Number767Copy();
        String s = number767_copy.reorganizeString("aaab");
        System.out.println(s);
    }
}
