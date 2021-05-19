package com.example.demo.project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: wanglong
 * @Date: 2021/3/24 17:07
 */
public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(4);
        set1.add(5);
        set2.add(1);
        set2.add(2);
        boolean b = set1.retainAll(set2);
        System.out.println(b);
        System.out.println(set1);

        Set<String> stringSet1 = new HashSet<>();
        stringSet1.add("a");
        Set<String> stringSet2 = new HashSet<>();
        stringSet2.add("a");
        boolean b1 = stringSet1.retainAll(stringSet2);
        System.out.println(b1);
        System.out.println(stringSet1);

        //求是否子集
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        Set<String> sss = new HashSet<>();
        sss.add("a");
        sss.add("d");
        System.out.println(set.containsAll(sss));

        //List转set去重
        List<String> list = Arrays.asList("a", "a", "b");
        Set<String> collect = new HashSet<>(list);
        System.out.println(collect.size());
    }
}
