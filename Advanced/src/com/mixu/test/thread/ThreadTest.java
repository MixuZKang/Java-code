package com.mixu.test.thread;


//创建Thread类的子类来新建多线程
public class ThreadTest {
    public static void main(String[] args) {

        MyThread thread1=new MyThread();
        //使用setName()方法设置线程名称
        thread1.setName("张三");
        thread1.start();
        //调用父类有参构造，把线程名称传递给父类，让父类给子线程起一个名字
        MyThread thread2=new MyThread("李四");
        thread2.start();

    }
}
