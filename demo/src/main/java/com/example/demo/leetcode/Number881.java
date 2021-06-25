package com.example.demo.leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/24 14:50
 */
public class Number881 {
    public int numRescueBoats(int[] people, int limit) {
        int numbers = 0;
        int[] ints = IntStream.of(people)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        Deque<Integer> deque = new LinkedList();
        for (int i = 0; i < ints.length; i++) {
            deque.offer(ints[i]);
        }
        while (!deque.isEmpty()) {
            //取出第一个
            Integer fist = deque.poll();
            numbers++;
            if (!deque.isEmpty() && limit - fist >= deque.getLast()) {
                deque.pollLast();
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        Number881 number881 = new Number881();
        int[] n = {1, 2};
        int i = number881.numRescueBoats(n, 3);
        System.out.println(i);
    }
}
