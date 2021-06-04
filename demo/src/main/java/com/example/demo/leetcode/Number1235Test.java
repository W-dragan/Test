package com.seeyon.udc.utils;

import com.example.demo.leetcode.Number1235;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wanglong
 * @Date: 2021/5/29 9:59
 */
public class Number1235Test {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Schedule> list = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            Schedule schedule = new Schedule();
            schedule.setStart(startTime[i]);
            schedule.setEnd(endTime[i]);
            schedule.setProfit(profit[i]);
            list.add(schedule);
        }
        //按照结束时间排序
        list.sort((Comparator.comparingInt(Schedule::getEnd)));
        int[] dp = new int[list.size() + 1];
        dp[0] = 0;
        for (int i = 1; i < list.size() + 1; i++) {
            //当前单次利润
            int now = list.get(i - 1).getProfit();
            //不做此次的最大利润
            int pre = dp[i - 1];
            //做此次的最大利润
            for (int j = i; j > 0; j--) {
                if (list.get(i - 1).getStart() >= list.get(j - 1).getEnd()) {
                    now = now + dp[j];
                    break;
                }
            }
            //取二者的最大值
            dp[i] = Math.max(now, pre);
        }
        return dp[list.size()];
    }


    public static void main(String[] args) {
        Number1235 number1235 = new Number1235();
//        int[] startTime = new int[]{1, 1, 1};
//        int[] endTime = new int[]{2, 3, 4};
//        int[] profit = new int[]{5, 6, 4};
//        int[] startTime = new int[]{1, 2, 3, 3};
//        int[] endTime = new int[]{3, 4, 5, 6};
//        int[] profit = new int[]{50, 10, 40, 70};
        int[] startTime = new int[]{1, 2, 3, 4, 6};
        int[] endTime = new int[]{3, 5, 10, 6, 9};
        int[] profit = new int[]{20, 20, 100, 70, 60};
        int i = number1235.jobScheduling(startTime, endTime, profit);
        System.out.println(i);
    }

}


class Schedule {
    private Integer start;
    private Integer end;
    private Integer profit;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }


}
