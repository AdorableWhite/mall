package com.taizilibai.mall.thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2021/1/28 16:45
 */
public class ThreadTest {

    class TimeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    @Test
    @DisplayName("守护线程 Daemon Thread")
    public void testDaemonThread() {
        // 线程共享变量 volatile修饰， 共享变量在线程之间的可见性
        // 创建守护线程， 守护线程不能有任何需要关闭的资源，JVM自动退出，没机会关闭
        Thread thread = new TimeThread();
        thread.setDaemon(true);
        thread.start();

        System.out.println("end");

    }

    static class Counter {
        public static final Object lock = new Object();
        public static int count = 0;
    }

    class AddThread extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                // synchronized 不需要担心抛出异常，无论是否有异常，都会在 synchronized 结束处正确释放锁
                synchronized (Counter.lock) {
                    Counter.count ++;
                }
            }
        }
    }

    class Add2Thread extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                synchronized(Counter.lock) {
                    Counter.count ++;
                }
            }
        }
    }

    @Test
    @DisplayName("线程同步")
//    @RepeatedTest(5)
    public void testThreadSynchronous() {
        long start = System.currentTimeMillis();
        AddThread addThread = new AddThread();
        Add2Thread add2Thread = new Add2Thread();
        addThread.start();
        add2Thread.start();

        try {
            addThread.join();
            add2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Counter.count);
        System.out.println(System.currentTimeMillis() - start);
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;

        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "x:" + x + "y:" + y;
        }
    }

    @Test
    @RepeatedTest(5)
    public void testPoint() {
        Point point = new Point(10, 10);

        Thread thread = new Thread(() -> {
            point.setX(20);
            point.setY(20);
        });
        Thread thread2 = new Thread(() -> {
            point.setX(30);
            point.setY(30);
        });
        thread.start();
        thread2.start();
        try {

            thread2.join();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(point);
    }

    // java 线程锁 为可重入锁（能被同一线程反复获取的锁）


    @Test
    @DisplayName("死锁")
    public void testDedLock() {
        Dead dead = new Dead();
        new Thread(() -> {
            dead.add(3);
        });
        new Thread(() -> {
            dead.des(4);
        });
        System.out.println(dead.value);
        System.out.println(dead.anotherValue);
    }

    static class Dead {
        public static final Object lockA = new Object();
        public static final Object lockB = new Object();

        int value = 0;
        int anotherValue = 0;
        public void add(int m) {
            synchronized (lockA) {
                this.value += m;
                synchronized (lockB) {
                    this.anotherValue += m;
                }
            }
        }

        public void des(int m) {
            synchronized (lockB) {
                this.anotherValue -= m;
                synchronized (lockA) {
                    this.value -= m;
                }
            }
        }
    }


}
