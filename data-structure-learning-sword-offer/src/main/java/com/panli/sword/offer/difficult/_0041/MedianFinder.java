package com.panli.sword.offer.difficult._0041;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 *
 * @author lipan
 * @date 2021-03-22
 */
public class MedianFinder {
    Queue<Integer> a, b;

    public MedianFinder() {
        a = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        }); // 大顶堆，存储较小的一部分
        b = new PriorityQueue<Integer>(); // 小顶堆，存储较大的一部分
    }

    public void addNum(int num) {
        if (a.size() != b.size()) {
            a.add(num);
            b.add(a.poll());
        } else {
            b.add(num);
            a.add(b.poll());
        }
    }

    public double findMedian() {
        return a.size() != b.size() ? a.peek() : (a.peek() + b.peek()) / 2d;
    }
}
