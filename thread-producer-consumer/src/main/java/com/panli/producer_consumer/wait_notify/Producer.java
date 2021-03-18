package com.panli.producer_consumer.wait_notify;

/**
 * 生产者
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Producer implements Runnable{

    private MyBlockingQueue storage;

    public Producer(MyBlockingQueue storage){
        this.storage = storage;
    }


    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                storage.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
