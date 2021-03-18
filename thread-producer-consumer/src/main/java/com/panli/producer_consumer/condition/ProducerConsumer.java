package com.panli.producer_consumer.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 借助 ReentrantLock 实现生产者消费者模式
 *
 * @author lipan
 * @date 2021-03-18
 */
public class ProducerConsumer {

    private Queue queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private ProducerConsumer(int max) {
        this.max = max;
        queue = new LinkedList();
    }

    public void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == max) {
                notFull.await();
            }
            queue.add(o);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            Object obj = queue.remove();
            System.out.println(obj);
            notFull.signalAll();
            return obj;
        } finally {
            lock.unlock();
        }
    }
}
