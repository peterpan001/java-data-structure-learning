package com.panli.dead_lock;

/**
 * 死锁：
 * jps 查看当前进程，
 * jstack pid，根据进程查看相关产生死锁线程信息
 *
 *
 * Found one Java-level deadlock:
 * =============================
 * "Thread-1":
 *   waiting to lock monitor 0x00007fb50e8202a8 (object 0x000000076ae8f658, a java.lang.String),
 *   which is held by "Thread-0"
 * "Thread-0":
 *   waiting to lock monitor 0x00007fb50e81da18 (object 0x000000076ae8f688, a java.lang.String),
 *   which is held by "Thread-1"
 *
 *
 * @author lipan
 * @date 2021-03-23
 */
public class LockTest {

    public static final String obj1 = "obj1";

    public static final String obj2 = "obj2";

    public static void main(String[] args) {
        LockA lockA = new LockA();
        LockB lockB = new LockB();

        new Thread(lockA).start();
        new Thread(lockB).start();
    }

}

class LockA implements Runnable {
    public void run() {
        try {
            synchronized (LockTest.obj1) {
                Thread.sleep(3000);
                System.out.println("LockA 获取到 obj1 锁");
                synchronized (LockTest.obj2) {
                    Thread.sleep(60 * 1000);
                    System.out.println("LockA 获取到 obj2 锁");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {
    public void run() {
        try {
            synchronized (LockTest.obj2) {
                Thread.sleep(3000);
                System.out.println("LockB 获取到 obj2 锁");
                synchronized (LockTest.obj1) {
                    Thread.sleep(60 * 1000);
                    System.out.println("LockB 获取到 obj1 锁");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


