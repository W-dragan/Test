package com.example.demo.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @Author: wanglong
 * @Date: 2021/6/4 14:21
 */
public class Number70 {
    //递归是最笨的办法
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if(n == 2){
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    /**
     * 动态规划,但是还是用了额外的空间n,还可以用中间变量更加优化
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        Number70 number70 = new Number70();
        int i = number70.climbStairs(3);
        System.out.println(i);
    }
}
