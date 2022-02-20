package com.mixu.test.thread;

public class MyThread extends Thread {
    public MyThread() {
    }
    //调用父类有参构造，把线程名称传递给父类，让父类给子线程起一个名字
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            //获取当前正在执行的线程，再返回线程名称
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                //让线程暂停300毫秒后再执行
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
