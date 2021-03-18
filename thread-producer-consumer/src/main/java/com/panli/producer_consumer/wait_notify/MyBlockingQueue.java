package com.panli.producer_consumer.wait_notify;

import java.util.LinkedList;

/**
 * 自定义阻塞队列
 *
 * @author lipan
 * @date 2021-03-18
 */
public class MyBlockingQueue {

    private int maxSize;
    private LinkedList<Object> storage;

    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        storage = new LinkedList<Object>();
    }

    public synchronized void put() throws InterruptedException {
        while (storage.size() == maxSize) {
            wait();
        }
        storage.add(new Object());
        notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        while (storage.size() == 0) {
            wait();
        }
        Object obj = storage.remove();
        System.out.println(obj.toString());
        notifyAll();
    }
}
