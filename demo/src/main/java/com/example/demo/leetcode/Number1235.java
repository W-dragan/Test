package com.example.demo.leetcode;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * <p>
 * <p>
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70
 * <p>
 * <p>
 * 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * 输出：150
 * 解释：
 * 我们选择第 1，4，5 份工作。
 * 共获得报酬 150 = 20 + 70 + 60。
 * <p>
 * <p>
 * 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * 输出：6
 * <p>
 * <p>
 * 思路：找出所有不冲突的schedule,比较谁的profit最大
 *
 * @Author: wanglong
 * @Date: 2021/5/28 16:22
 */
public class Number1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Schedule> list = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            Schedule schedule = new Schedule();
            schedule.setStart(startTime[i]);
            schedule.setEnd(endTime[i]);
            schedule.setProfit(profit[i]);
            list.add(schedule);
        }
        list.sort((Comparator.comparingInt(Schedule::getStart)));
        return resolve(0, 1, list);
    }

    /**
     * 递归解出,不过,复杂度太高,数据量稍微一大爆栈了
     *
     * @param i
     * @param start
     * @param list
     * @return
     */
    public int resolve(int i, int start, List<Schedule> list) {
        System.out.println(i + ";" + start);
        if (i >= list.size()) {
            return 0;
        }
        int doSchedule = 0;
        if (list.get(i).getStart() >= start) {
            doSchedule = list.get(i).getProfit() + resolve(i + 1, list.get(i).getEnd(), list);
        }
        int notDoSchedule = resolve(i + 1, start, list);
        return Math.max(doSchedule, notDoSchedule);
    }

    public static void main(String[] args) {
        Number1235 number1235 = new Number1235();
//        int[] startTime = new int[]{1, 1, 1};
//        int[] endTime = new int[]{2, 3, 4};
//        int[] profit = new int[]{5, 6, 4};
        int[] startTime = new int[]{1, 2, 3, 3};
        int[] endTime = new int[]{3, 4, 5, 6};
        int[] profit = new int[]{50, 10, 40, 70};
        int i = number1235.jobScheduling(startTime, endTime, profit);
        System.out.println(i);
    }

}

@Setter
@Getter
class Schedule {
    private Integer start;
    private Integer end;
    private Integer profit;

}
