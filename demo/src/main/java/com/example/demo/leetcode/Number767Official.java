package com.example.demo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wanglong
 * @Date: 2021/6/24 10:30
 */
public class Number767Official {
    /**
     * 基于最大堆的贪心
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        //26个字母数组开始放对应的次数
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        //如果超过一半,说明必不能完成
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        //优先队列,根据出现次数由大到小排序
        PriorityQueue<Character> queue = new PriorityQueue<>((letter1, letter2) -> counts[letter2 - 'a'] - counts[letter1 - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        //如果队列不为空
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a';
            int index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "bba";
        Number767Official number767Official = new Number767Official();
        String s1 = number767Official.reorganizeString(s);
        System.out.println(s1);
    }
}
