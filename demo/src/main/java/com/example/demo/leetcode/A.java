package com.example.demo.leetcode;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: wanglong
 * @Date: 2021/3/24 20:57
 */
public class A {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{2, 3}, {2, 5}, {3, 5}};
//        Boolean redundantConnection = findRedundantConnection(arr);
//        System.out.println(redundantConnection);
        Map<String, Set<String>> map = new HashMap<>();
        HashSet<String> a = new HashSet<>();
        a.add("B");
        map.put("A", a);
        HashSet<String> b = new HashSet<>();
        b.add("A");
        map.put("B", b);
        Map<String, Integer> mapping = resolveMapping(map);
        System.out.println(mapping);
        int[][] ints = toArray(map, mapping);
        System.out.println(Arrays.deepToString(ints));
        int[] redundantConnection = findRedundantConnection(ints);
        System.out.println(Arrays.toString(redundantConnection));

    }

    public static int[][] toArray(Map<String, Set<String>> map, Map<String, Integer> mapping) {
        int[][] edges;
        IdentityHashMap<String, String> stringIdentityHashMap = new IdentityHashMap<>();
        map.forEach((k, v) -> {
            v.forEach(
                    value -> {
                        stringIdentityHashMap.put(new String(k), value);
                    }
            );
        });
        edges = new int[stringIdentityHashMap.size()][2];
        int i = 0;
        for (Map.Entry<String, String> entry : stringIdentityHashMap.entrySet()) {
            edges[i][0] = mapping.get(entry.getKey());
            edges[i][1] = mapping.get(entry.getValue());
            i++;
        }
        return edges;
    }

    public static Map<String, Integer> resolveMapping(Map<String, Set<String>> map) {
        Map<String, Integer> mapping = new HashMap<>();
        Set<String> keySet = map.keySet();
        int i = 0;
        for (String key : keySet) {
            mapping.put(key, i);
            i++;
        }
        Set<String> valueSet = new HashSet<>();
        List<Set<String>> list = new ArrayList<>(map.values());
        for (Set<String> value : list) {
            valueSet.addAll(value);
        }
        for (String value : valueSet) {
            Integer integer = mapping.getOrDefault(value, -1);
            if (integer == -1) {
                mapping.put(value, i);
                i++;
            }
        }
        return mapping;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int[] arr : edges) {
            boolean union = unionFind.union(arr[0], arr[1]);
            //成环就返回,因为边没有重复的,一旦形成环后,后面出现的边也无法改变目前这个环的状态
            if (!union) {
                return arr;
            }
        }
        return null;
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            int rootX = parent[x];
            if (rootX != x) {
                parent[x] = find(rootX);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }

}
