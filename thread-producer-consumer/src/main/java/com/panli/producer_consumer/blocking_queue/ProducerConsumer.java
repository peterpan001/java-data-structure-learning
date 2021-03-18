package com.panli.producer_consumer.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 借助线程安全的队列实现生产者消费者模式
 *
 * @author lipan
 * @date 2021-03-18
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        final BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(10);

        // 生产者
        Runnable producer = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        queue.put(new Object());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // 消费者
        Runnable consumer = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Object take = queue.take();
                        System.out.println(take.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // 开启生产者-消费者消费
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
