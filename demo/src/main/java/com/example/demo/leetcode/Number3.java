package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/**
 * @Author: wanglong
 * @Date: 2021/5/26 20:22
 */
public class Number3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    //    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        int result = 0;
//        int max = 0;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if(set.contains(s.charAt(j))){
//                    set.clear();
//                    result = Math.max(result, max);
//                    max = 0;
//                    break;
//                }
//                set.add(s.charAt(j));
//                max++;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Number3 number3 = new Number3();
        int abcabcbb = number3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }
}
