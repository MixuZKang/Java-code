package com.mixu.test.thread;

/*
* 1.Runnable里面没有start方法，所以要创建一个Thread对象，在里面
*   传递一个Runnable接口的实现类对象，再用Thread对象调用start方法
* 2.创建多线程的方法尽量使用实现Runnable接口的方法，因为实现了
*   Runnable接口还可以继承其他的类，使用继承Thread类的方法则不能再继承别的类
* */
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread thread=new Thread(new RunnableImpl());
        thread.start();
    }
}
