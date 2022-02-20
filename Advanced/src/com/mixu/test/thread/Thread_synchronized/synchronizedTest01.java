package com.mixu.test.thread.Thread_synchronized;

/*
使用同步代码块模拟卖票：
    同步代码块：当使用多个线程访问同一资源，且多个线程中对资源有写的操作时，就容易出现线程安全问题，使用同步代码块就能解决
    格式：
        synchronized(锁对象){
            可能出现线程安全问题的代码(或者说访问了共享数据的代码)
        }
    1.同步代码块保证了只能有一个线程在同步中执行共享数据，当此线程操作完后其他线程才有机会进入代码去执行，保证了线程安全。
    2.但同步代码块会让程序频繁的获取锁、释放锁，从而降低程序的效率
*/
public class synchronizedTest01 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            //定义五十张票
            private int ticket = 50;

            @Override
            public void run() {
                while (true) {
                    //创建同步代码块，防止出现线程安全问题，需要传递一个锁对象(可以是任意对象)
                    synchronized (this) {
                        if (ticket > 0) {
                            try {
                                //为了提高线程安全问题出现的概率，让线程睡眠
                                Thread.sleep(10);
                                System.out.println(Thread.currentThread().getName() + ":正在卖第" + ticket + "张票");
                                ticket--;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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
