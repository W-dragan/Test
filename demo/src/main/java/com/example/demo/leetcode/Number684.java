package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * <p>
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * <p>
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/28 16:10
 */
public class Number684 {
    public static void main(String[] args) {
        Number684 number684 = new Number684();
//        int[][] edge = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[][] edge = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] redundantConnection = number684.findRedundantConnection(edge);
        System.out.println(Arrays.toString(redundantConnection));
    }

    /**
     * 找冗余连接
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            int i0 = edge[0];
            int i1 = edge[1];
            boolean union = unionFind.union(i0, i1);
            if (union) {
                return new int[]{i0, i1};
            }
        }
        return new int[]{};
    }


    private static class UnionFind {

        private int[] parent;

        /**
         * 初始化
         *
         * @param n
         */
        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 查找
         *
         * @param x
         * @return
         */
        private int find(int x) {
            int rootX = parent[x];
            if (rootX != x) {
                parent[x] = find(rootX);
            }
            return parent[x];
        }

        /**
         * 合并
         *
         * @param x
         * @param y
         * @return
         */
        private boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return true;
            }
            parent[rootX] = rootY;
            return false;
        }
    }
}
