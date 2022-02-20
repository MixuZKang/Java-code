package com.mixu.test.thread.Thread_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//模拟卖票，使用Lock锁解决线程安全问题
public class synchronizedTest03 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            private int ticket = 50;
            //在成员位置创建一个Lock的实现类ReentrantLock对象
            Lock reentrantLock = new ReentrantLock();

            @Override
            public void run() {
                while (true) {
                    //在可能会出现安全问题的代码前面调用Lock接口中的方法lock()获取锁
                    reentrantLock.lock();
                    if (ticket > 0) {
                        try {
                            Thread.sleep(30);
                            System.out.println(Thread.currentThread().getName() + ":正在卖第" + ticket + "张票");
                            ticket--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            //在可能会出现安全问题的代码后面调用Lock接口中的方法unlock()释放锁
                            reentrantLock.unlock();//通常放在finally块中，无论程序是否异常都会释放锁
                        }
                    }
                }
            }
        };

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t0.start();
        t1.start();
        t2.start();
    }
}
