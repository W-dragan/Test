package com.example.demo.leetcode;

/**
 * @Author: wanglong
 * @Date: 2021/3/24 20:44
 */
public class DisjointSet {
    public String[] findRedundantConnection(String[][] args) {
        return null;
    }

    class UnionFind {
        int[] parents;
        int[] ranks;

        public UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (ranks[rootX] > ranks[rootY]) {
                parents[rootY] = rootX;
            }
            if (ranks[rootX] < ranks[rootY]) {
                parents[rootX] = rootY;
            }
            if (ranks[rootX] == ranks[rootY]) {
                parents[rootY] = rootX;
                ranks[rootX]++;
            }

        }

        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            System.out.println(x + ":" + parents[x]);
            return parents[x];
        }
    }
}
