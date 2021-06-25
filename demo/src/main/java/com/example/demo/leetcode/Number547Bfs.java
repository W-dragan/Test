package com.example.demo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 也可以通过广度优先搜索的方法得到省份的总数。对于每个城市，如果该城市尚未被访问过，
 * 则从该城市开始广度优先搜索，直到同一个连通分量中的所有城市都被访问到，即可得到一个省份。
 *
 * @Author: wanglong
 * @Date: 2021/6/24 19:38
 */
public class Number547Bfs {

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }
    public static void main(String[] args) {
        Number547Bfs number547 = new Number547Bfs();
//        int[][] arr = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] arr = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int circleNum = number547.findCircleNum(arr);
        System.out.println(circleNum);
    }
}
