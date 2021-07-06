package com.example.demo.leetcode;

/**
 * @Author: wanglong
 * @Date: 2021/7/5 17:11
 */
public class Number1319_Official {

    int[] f = new int[(int) 1e5];

    public int find(int x) {
        if (f[x] == x) {
            return x;
        }
        //路径压缩
        return f[x] = find(f[x]);
    }

    public int makeConnected(int n, int[][] connections) {
        //如果初始布线数小于 n - 1，那么一定不能使所有计算机连通
        if (connections.length < n - 1) {
            return -1;
        }
        //并查集初始化
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        //初始化连通分量数为 n
        int cnt = n;
        for (int[] connection : connections) {
            int fx = find(connection[0]);
            int fy = find(connection[1]);
            if (fx != fy) {
                //合并两个连通分量
                f[fx] = fy;
                //连通分量数减1
                cnt--;
            }
        }
        return cnt - 1;
    }
}
