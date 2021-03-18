package com.panli.producer_consumer.wait_notify;

/**
 * 消费者
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Consumer implements Runnable {

    private MyBlockingQueue storage;

    public Consumer(MyBlockingQueue storage) {
        this.storage = storage;
    }


    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
