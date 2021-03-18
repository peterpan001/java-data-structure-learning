package com.panli.producer_consumer.wait_notify;

/**
 * @author lipan
 * @date 2021-03-18
 */
public class WaitStyle {

    public static void main(String[] args) {

        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);

        Producer producer = new Producer(myBlockingQueue);
        Consumer consumer = new Consumer(myBlockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
