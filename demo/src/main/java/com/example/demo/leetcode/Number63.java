package com.example.demo.leetcode;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @Author: wanglong
 * @Date: 2021/6/18 15:08
 */
public class Number63 {
    /**
     * 不是dp,而是滑动窗口
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //此处为了防止空数组
        int min = Integer.MAX_VALUE;
        int max = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = 0;
            } else if (prices[i] > max) {
                max = prices[i];
            }
            profit = Math.max(profit, max - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        Number63 number63 = new Number63();
        int[] prices = {7, 6, 4, 3, 1};
        int i = number63.maxProfit(prices);
        System.out.println(i);
    }
}
