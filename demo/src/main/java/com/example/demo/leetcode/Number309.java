package com.example.demo.leetcode;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 *
 * @Author: wanglong
 * @Date: 2021/6/17 20:41
 */
public class Number309 {
    /**
     * 动态规划
     * 三种情况：
     * 1 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]
     * 对于 f[i][0],我们目前持有的这一支股票可以是在第 i-1天就已经持有的,对应的状态为 f[i-1][0]；
     * 或者是第 i 天买入的，那么第 i-1天就不能持有股票并且不处于冷冻期中，
     * 对应的状态为 f[i-1][2]加上买入股票的负收益 prices[i]
     * f[i][0]=max(f[i−1][0],f[i−1][2]−prices[i])
     * 2 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1];
     * 对于f[i][1],目前处于冷冻期,说明前一天进行了卖出操作,即前一天必须持有股票
     * f[i][1] = f[i-1][0] + price[i]
     * 3 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2];
     * 对于 f[i][2],我们在第 i 天结束之后不持有任何股票并且不处于冷冻期，说明当天没有进行任何操作，即第 i-1天时不持有任何股票：
     * 如果处于冷冻期，对应的状态为 f[i-1][1]；如果不处于冷冻期，对应的状态为 f[i-1][2]。因此状态转移方程为：
     * <p>
     * f[i][2] = max(f[i-1][1], f[i-1][2])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
        Number309 number309 = new Number309();
        int[] nums = {1, 2, 3, 0, 2};
        int i = number309.maxProfit(nums);
        System.out.println(i);
    }
}
