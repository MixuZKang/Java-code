package com.mixu.test.FunctionalInterface.demo2;

import java.util.function.Predicate;

public class PredicateTest {
    /*
    * 定义一个方法，方法传递一个字符串和两个Predicate接口
    * 判断字符串是否同时满足长度大于5和包含a
    * test方法是个用于条件判断的抽象方法，返回一个布尔值
    * */
    public static boolean checkString(String s, Predicate<String> pre1,Predicate<String> pre2){
        //return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);//等价于上一行代码
        //Predicate里的or方法 代表“或||” 用法类似于and方法
        //Predicate里的negate方法表示 “!取反”
    }
    public static void main(String[] args) {
        String s="bdsdddsad";
        boolean b = checkString(s,(String str)->{
            //判断字符串长度是否大于5
            return str.length()>5;
        },(String str)->{
            //判断字符串是否包含a
            return str.contains("a");
        });
        System.out.println(b);
    }
}
