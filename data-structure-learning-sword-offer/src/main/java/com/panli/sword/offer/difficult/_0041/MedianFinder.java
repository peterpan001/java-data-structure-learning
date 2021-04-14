package com.panli.sword.offer.difficult._0041;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 *
 * @author lipan
 * @date 2021-03-22
 */
public class MedianFinder {

    Queue<Integer> small, big;

    public MedianFinder() {
        small = new PriorityQueue<>(); // 小顶堆，存较大的一部分
        big = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，存较小的一部分
    }

    public void addNum(int num) {
        if (small.size() == big.size()) {
            small.add(num);
            big.add(small.poll());
        } else {
            big.add(num);
            small.add(big.poll());
        }
    }

    public double findMedian() {
        return small.size() == big.size() ? (small.peek() + big.peek()) / 2.0 : big.peek();
    }

}
