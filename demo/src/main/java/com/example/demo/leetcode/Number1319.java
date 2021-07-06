package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1
 * <p>
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * <p>
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/7/5 15:28
 */
public class Number1319 {
    /**
     * 先找到冗余连接
     * 然后找到有几个门派,门派数需要路径压缩
     * 1 门派数为1 则自成一派不用连接
     * 2 门派数不为1,则找冗余连接 门派数 <= 冗余连接 + 1 则可以
     *
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] connect : connections) {
            unionFind.union(connect[0], connect[1]);
        }
        //冗余连接
        int connect = unionFind.redundantConnect;
        //连通分量
        int size = unionFind.connectedComponents;
        if (size == 1) {
            return 0;
        }
        if (size > connect + 1) {
            return -1;
        }
        if (size <= connect + 1) {
            return size - 1;
        }
        return 0;
    }

    private static class UnionFind {
        int[] parent;
        //冗余连接
        int redundantConnect;
        /// rank[i]表示以i为根的集合所表示的树的层数
        int[] rank;
        //连通分量
        int connectedComponents;

        public UnionFind(int n) {
            connectedComponents = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rootX < rootY) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                }
                connectedComponents--;
                return true;
            }
            redundantConnect++;
            return false;
        }

        public int find(int x) {
            int rootX = parent[x];
            if (rootX == x) {
                return parent[x];
            } else {
                parent[x] = find(rootX);
                return parent[x];
            }
        }
    }

    public static void main(String[] args) {
        Number1319 number1319 = new Number1319();
        int[][] nums = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int i = number1319.makeConnected(6, nums);
//        int[][] nums = new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        System.out.println(i);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
//    public void unionElements(int x, int y) {
//
//        int rootX = find(x);
//        int rootY = find(y);
//
//        if (rootX == rootY) {
//            redundantConnect++;
//            return;
//        }
//        if (rank[rootX] < rank[rootY]) {
//            parent[rootX] = rootY;
//        } else if (rank[rootY] < rank[rootX]) {
//            parent[rootY] = rootX;
//        } else {
//            // rank[pRoot] == rank[qRoot]
//            parent[rootX] = rootY;
//            rank[rootY] += 1;   // 维护rank的值
//        }
//    }
}
