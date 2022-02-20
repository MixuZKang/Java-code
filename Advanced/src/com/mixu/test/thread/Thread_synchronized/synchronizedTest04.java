package com.mixu.test.thread.Thread_synchronized;


/*
   1.进入到 TimeWaiting(计时等待) 有两种方式:
    * 使用sleep方法：在毫秒值结束后，线程睡醒进入到Runnable(运行)/Blocked(堵塞)状态
    * 使用wait方法：wait方法如果在毫秒值结束后还没有被notify唤醒，
            就会自己醒来，线程睡醒进入到Runnable(运行)/Blocked(堵塞)状态

   2.notify():如果有多个等待线程，随机唤醒一个
     notifyAll():唤醒所有等待的线程

   3.wait方法和notify方法必须要在同步代码块或同步函数中使用，
        因为必须通过锁对象调用这两个方法，且这两个方法*必须要由同一个锁对象调用*

*/
public class synchronizedTest04 {
    public static void main(String[] args) {
        Object obj = new Object();
        //首先创建一个顾客线程
        Thread thread = new Thread(() -> {
            synchronized (obj) {
            //synchronized (new Object()) { //错误，锁对象虽然可以是任意的，但是要求多个线程必须共用同一个锁对象
                System.out.println(Thread.currentThread().getName() + ":告知老板要的包子种类和数量");
                try {
                    //让顾客线程进入等待状态
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //顾客线程被老板线程唤醒，继续执行后续代码
                System.out.println(Thread.currentThread().getName() + ":吃包子");
            }
        });
        thread.setName("顾客");
        thread.start();

        //然后创建一个包子铺老板线程
        Thread thread1 = new Thread(() -> {
            for (int i = 5; i >= 1; i--) {
                try {
                    Thread.sleep(500);
                    System.out.println("正在做包子中，还有" + i + "秒做完");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + ":包子做好了，告知顾客");
                //唤醒等待顾客的线程
                obj.notify();
            }
        });
        thread1.setName("老板");
        thread1.start();
    }
}
