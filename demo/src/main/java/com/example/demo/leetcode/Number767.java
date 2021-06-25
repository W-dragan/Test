package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 *
 * @Author: wanglong
 * @Date: 2021/6/23 16:14
 */
public class Number767 {
    /**
     * 1.用map存储字符和对应出现次数,按出现次数排序
     * 2.从大到小往里插入,只出现一个的说明肯定不会重复,不到万不得已不要庆以用只出现一次的插入
     *
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
        List<Character> list = new ArrayList<>();

        map.entrySet().stream()
                //按大小排序
                .sorted((p1, p2) -> p2.getValue() - p1.getValue())
                .forEach(entry -> {
                    if (entry.getValue() > 1) {
                        //大于1的放到map
                        out.put(entry.getKey(), entry.getValue());
                    } else {
                        //等于1的放到list里面
                        list.add(entry.getKey());
                    }
                });
        StringBuilder sb = new StringBuilder();
        while (!out.isEmpty()) {

            Iterator<Map.Entry<Character, Integer>> iterator = out.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Character, Integer> entry = iterator.next();
                sb.append(entry.getKey());
                //如果map的size为1,说明只剩这一个重复的,只能和出现一次的进行配对
                if (out.size() == 1 && !list.isEmpty()) {
                    sb.append(list.get(0));
                    list.remove(0);
                }
                //用了以后次数减一,如果彻底用完则移除
                if (entry.getValue() - 1 == 0) {
//                    out.remove(entry.getKey());
                    iterator.remove();
                } else {
                    entry.setValue(entry.getValue() - 1);
                }
                if (out.size() == 1 && entry.getValue() == 0) {
                    out.clear();
                    break;
                }
                if (out.size() == 1 && entry.getValue() > 1 && list.isEmpty()) {
                    sb = new StringBuilder("");
                    out.clear();
                    break;
                }
            }

        }
        //如果列表非空,说明还有剩余需要拼接
        if(!list.isEmpty()){
            for(Character l:list){
                sb.append(l);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Number767 number767 = new Number767();
        //vvvlo
        //babaa
        //bfrbs
        //eqmeyggvp
        //kkkkzrkatkwpkkkktrq
        String s = number767.reorganizeString("kkkkzrkatkwpkkkktrq");
        System.out.println(s);

    }
}
