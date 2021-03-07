package com.panli.sword.offer.easy._0062;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 输入: n = 5, m = 3
     * 输出: 3
     * <p>
     * 第一轮是 [0, 1, 2, 3, 4] ，所以是 [0, 1, 2, 3, 4] 这个数组的多个复制。这一轮 2 删除了。
     * 第二轮开始时，从 3 开始，所以是 [3, 4, 0, 1] 这个数组的多个复制。这一轮 0 删除了。
     * 第三轮开始时，从 1 开始，所以是 [1, 3, 4] 这个数组的多个复制。这一轮 4 删除了。
     * 第四轮开始时，还是从 1 开始，所以是 [1, 3] 这个数组的多个复制。这一轮 1 删除了。
     * 最后剩下的数字是 3。
     * <p>
     * 图中的绿色的线指的是新的一轮的开头是怎么指定的，每次都是固定地向前移位 m 个位置。
     * <p>
     * 然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。
     * <p>
     * 最后剩下的 3 的下标是 0。
     * <p>
     * 第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。
     * 第三轮反推，补上 m 个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。
     * 第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。
     * 第一轮反推，补上 m 个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。
     * <p>
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     * <p>
     * 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    /**
     * 假设当前删除的位置是 idx，下一个删除的数字的位置是 idx + m 。但是，由于把当前位置的数字删除了，后面的数字会前移一位，
     * 所以实际的下一个位置是 idx + m - 1。由于数到末尾会从头继续数，所以最后取模一下，就是 (idx + m -1) mod n
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
