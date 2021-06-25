package com.example.demo.leetcode;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 输入: N = 332
 * 输出: 299
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: wanglong
 * @Date: 2021/6/23 14:35
 */
public class Number738 {
    /**
     * 方法一：贪心
     * 我们可以从高到低按位构造这个小于等于 n 的最大单调递增的数字。假设不考虑 n 的限制，那么对于一个长度为 k 的数字，
     * 最大单调递增的数字一定是每一位都为 9 的数字。
     * <p>
     * 记 strN[i] 表示数字 n 从高到低的第 i 位的数字（i 从 0 开始）。
     * <p>
     * 如果整个数字 n 本身已经是按位单调递增的，那么最大的数字即为 n。
     * <p>
     * 如果找到第一个位置 i 使得 [0,i-1] 的数位单调递增且 strN[i−1]>strN[i]，此时 [0,i] 的数位都与 n 的对应数位相等，仍然被 n 限制着，
     * 即我们不能随意填写 [i+1,k-1] 位置上的数字。为了得到最大的数字，我们需要解除 n 的限制，来让剩余的低位全部变成 9 ，
     * 即能得到小于 n 的最大整数。而从贪心的角度考虑，我们需要尽量让高位与 n 的对应数位相等，故尝试让 strN[i−1] 自身数位减 1。
     * 此时已经不再受 n 的限制，直接将 [i,k−1] 的位置上的数全部变为 9 即可。
     * <p>
     * 但这里存在一个问题：当 strN[i−1] 自身数位减 1 后可能会使得 strN[i−1] 和 strN[i−2] 不再满足递增的关系，
     * 因此我们需要从 i-1 开始递减比较相邻数位的关系，直到找到第一个位置 j 使得 strN[j] 自身数位减 1 后 strN[j−1] 和 strN[j] 仍然保持递增关系，
     * 或者位置 j 已经到最左边（即 j 的值为 0），此时我们将 [j+1,k−1] 的数全部变为 9 才能得到最终正确的答案。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/dan-diao-di-zeng-de-shu-zi-by-leetcode-s-5908/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        //找到不满足单调递增的位置
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            //高位依次降位
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static void main(String[] args) {
        Number738 number738 = new Number738();
        number738.monotoneIncreasingDigits(100);
    }

}
