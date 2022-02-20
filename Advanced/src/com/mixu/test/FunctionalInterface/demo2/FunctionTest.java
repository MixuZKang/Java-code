package com.mixu.test.FunctionalInterface.demo2;

import java.util.function.Function;

/*
 * Function的常用方法：
 * 1、R apply(T t)方法可以进行类型转换，根据类型T的参数获取类型R的结果
 *    如传递一个String类型的数据返回一个int类型的数据
 *    这种转换形式也可以称为映射
 * 2、andThen方法：
 *    先把一个String类型转换成Integer类型
 *    Integer i = fun1.apply("123");
 *    然后把一个Integer类型转换成String类型
 *    String s = fun2.apply(i);
 *    使用andThen方法可以把两个步骤合在一起
 *    String s = fun1.andThen(fun2).apply("123");
 *    fun1先调用apply方法，把字符串转化为Integer
 *    fun2再调用apply方法，把Integer转换为字符串
 * */
public class FunctionTest {
    /*
     * 定义一个方法：
     * 参数传递字符串，包含姓名和年龄
     * 参数再传递三个Function接口用于类型转换
     * 1、把身高部分截取出来得到字符串：“张三，160”->“160”
     * 2、把上一步截取出来的字符串转换成int类型的数字：“160”->160
     * 3、把上一把int类型的数字加上20，得到结果也为int数字：160->180
     * */
    public static int change(String s, Function<String, String> fun1,
                             Function<String, Integer> fun2,
                             Function<Integer, Integer> fun3) {
        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

    public static void main(String[] args) {
        String str = "张三，160";
        int num = change(str, (String s) -> {
            //获取字符串里的年龄，返回String类型的年龄
            return s.split("，")[1];
        }, (String s) -> {
            //把String类型的年龄转化为int类型的年龄
            return Integer.parseInt(s);
        }, (Integer i) -> {
            //把int类型的数字加上20
            return i + 20;
        });
        System.out.println(num);
    }
}
