package com.mixu.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//实现Callable接口的方式
class CallableImpl implements Callable<Integer> {

    //与Runnable不同的是Callable的实现方法具有返回值，还可以抛出异常、指定泛型
    @Override
    public Integer call() throws Exception {//遍历100以内的偶数并返回偶数的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadTest5 {
    public static void main(String[] args) {
        //使用Callable需要实现一个FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableImpl());
        //同样需要new一个Thread，构造中传入FutureTask
        new Thread(futureTask).start();

        try {
            //get()方法返回值为Callable的call()的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
