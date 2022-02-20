package com.mixu.test.FunctionalInterface.demo1;

/*
* Lambda表达式的格式：
*   一些参数 一个箭头 一段代码
*   (参数列表) -> {重写方法的代码};
*   () ：接口中抽象方法的参数列表
*   -> ：把参数传递给方法体{}
*   {} ：重写接口的抽象方法的方法体
* Lambda表达式的使用前提：
*   必须具有接口，接口里有且仅有一个抽象方法(函数式接口)
* */
public class LambdaTest {
    public static void main(String[] args) {
        //使用匿名内部类的方式实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        //使用Lambda表达式实现多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

        //更简化的方式写Lambda表达式
        //参数列表的数据类型可以不写，如果参数只有一个()也能不写
        //只要方法体只有一条，无论是否有返回值都可以省略掉{} return ;(必须一起省略)
        new Thread(() ->
                System.out.println(Thread.currentThread().getName())
        ).start();

    }
}
