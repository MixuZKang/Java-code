package com.mixu.test.thread.Thread_synchronized;

//演示同步方法
class RunnableImpl implements Runnable {
    private static int ticket = 50;

    @Override
    public void run() {
        while (true) {
            //调用同步方法
            payTicket();
        }
    }

    //同步方法的锁对象：当前对象this，也就是实例化实现类时new RunnableImpl()创建的对象
    public synchronized void payTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":正在卖第" + ticket + "张票");
            ticket--;
        }
    }

    /*
      静态同步方法的锁对象：不能是this，只有实例方法中才有this，静态方法中不存在this，
      因为this是创建对象后产生的，而静态方法是创建对象之前就进入内存了，它优先于对象。
      静态同步方法的锁对象是本类的class类对象-->RunnableImpl.class
    */
    public static synchronized void payTicketStatic() {
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":正在卖第" + ticket + "张票");
            ticket--;
        }
    }

}

//测试同步方法
public class synchronizedTest02 {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableImpl());
        thread.start();
    }
}
