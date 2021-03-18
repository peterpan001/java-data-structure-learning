package com.panli.singleton.double_check;

/**
 * 单例模式：双重检查锁机制
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
