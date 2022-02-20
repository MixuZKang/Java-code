package com.mixu.test.FunctionalInterface.demo2;

import java.util.function.Consumer;

/*
* Consumer接口：
* accept方法给一个指定类型的数据,然后对数据进行消费(使用)
* 具体怎么使用需要我们自定义(输出，计算...)
* */
public class ConsumerTest {
    //定义一个方法，参数传递一个字符串数组和两个Consumer接口，用于输出指定格式的信息(姓名：xx 性别：xx)
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2){
        for (String message : arr) {
            //使用accept方法消费(使用)每一个字符串
            con1.andThen(con2).accept(message);
        }
    }
    public static void main(String[] args) {
        String[] arr={"张三,男","冠希,男","李四,女","王五,男"};
        printInfo(arr,(String m)->{
            //对参数进行切割，获取姓名
            String name = m.split(",")[0];
            System.out.print("姓名："+name);
        },(String m)->{
            //对参数进行切割，获取性别
            String sex = m.split(",")[1];
            System.out.println("-性别："+sex);
        });
    }
}
