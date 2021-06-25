package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
 * 输出：1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/24 16:36
 */
public class Number547 {
    /**
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        int num = 0;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        int[] parent = unionFind.parent;
        //合并以后,只要是parent[i]和i不相等,说明被合并过,一定是属于某个根的子集,不用加
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == i){
                num++;
            }
        }
        return num;
    }


    static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
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
        public int find(int x) {
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

    public static void main(String[] args) {
        Number547 number547 = new Number547();
        int[][] arr = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
//        int[][] arr = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int circleNum = number547.findCircleNum(arr);
        System.out.println(circleNum);
    }

}
