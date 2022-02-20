package com.mixu.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    1.线程池的底层原理就是用一个集合(容器)，在程序首次启动的时候
      创建多个线程，保存到集合中。需要用的时候就从集合中取出一个
      线程来使用，使用完毕后归还线程给集合
    2.线程池会一直开启，使用完了线程会把线程归还给线程池,线程可以继续使用
    3.如果需要销毁线程池，可以调用ExecutorService的shutdown()方法(不建议使用)
*/
public class ThreadTest4 {
    public static void main(String[] args) {
        //使用生产线程池的工厂类Executors里的方法newFixedThreadPool生产一个指定线程数量的线程池
        //方法返回一个ExecutorService线程池接口
        ExecutorService service = Executors.newFixedThreadPool(5);
        //调用ExecutorService的execute()方法，参数传递线程任务(实现类)，开启线程执行run方法
        service.execute(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        //execute()方法时候传入Runnable实现类，还有一种调用方式submit()，适合传入Callable实现类
        //service.submit();

        //关闭线程池
        service.shutdown();
    }
}
