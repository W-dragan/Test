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
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        dfs(combinations, 0, phoneMap, sb, digits);
        return combinations;
    }

    /**
     *
     * @param res 返回结果
     * @param begin 开始位置
     * @param phoneMap 数字字母映射
     * @param path 目前已存的路径
     * @param digits 入参
     */
    private void dfs(List<String> res, int begin, Map<Character, String> phoneMap, StringBuilder path, String digits) {
        if (digits.length() == path.length()) {
            res.add(path.toString());
            return;
        }
        if (path.length() < digits.length()) {
            char c = digits.charAt(begin);
            String s = phoneMap.get(c);
            for (int i = 0; i < s.length(); i++) {
                path.append(s.charAt(i));
                dfs(res, begin + 1, phoneMap, path, digits);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Number17 number17 = new Number17();
        List<String> list = number17.letterCombinations("79");
        System.out.println(list.toString());
    }
}
