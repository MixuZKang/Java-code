package com.mixu.test.thread;

public class ThreadTest3 {
    public static void main(String[] args) {
        //使用匿名内部类实现线程的创建
        new Thread(){
            @Override
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();

        //使用匿名内部类实现线程的创建
        Runnable runnable=new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        };
        new Thread(runnable).start();

        //***同时使用匿名内部类和匿名对象，推荐使用该方法创建线程***
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }).start();

    }
}
