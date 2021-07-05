package com.example.demo.leetcode;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * <p>
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * <p>
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/22 20:42
 */
public class Number765 {
    /**
     * 1 什么叫情侣不能牵手
     * 2 什么叫两对情侣不能牵手
     * 3 什么叫三对情侣不能牵手
     * 4 如何是用最少交换次数使情侣可以牵手成功
     * 通过举例，可以知道把 坐错了位置、逻辑上连在一起的情侣 拆成所有的情侣都能彼此牵手的 「最少交换次数 = 情侣对数 - 1」
     * 至少交换的次数 = 所有情侣的对数 - 并查集里连通分量的个数
     *
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int n = len / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < len; i += 2) {
            //合并商
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionFind.getCount();
    }

    private static class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }
        //初始化赋值
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            //压缩路径
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count--;
        }
    }

    public static void main(String[] args) {
        int[] couple = {0, 3, 2, 1, 4, 5, 6, 7};
        Number765 number765 = new Number765();
        int i = number765.minSwapsCouples(couple);
        System.out.println(i);
    }

}
