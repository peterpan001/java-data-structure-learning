package com.panli.queue.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 两个队列模拟栈
 */
public class QueueToStack {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // 队列模拟进栈
    public void push(int item) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(item);
            return;
        }
        if (queue1.isEmpty()) {
            queue2.add(item);
            return;
        }
        if (queue2.isEmpty()) {
            queue1.add(item);
            return;
        }
    }

    // 队列模拟出栈
    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return -1;
        }
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return -1;
    }
}
