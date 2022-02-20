package com.mixu.test.FunctionalInterface.demo1;

import java.util.Arrays;
import java.util.Comparator;

//函数式接口作为返回值：
public class LambdaTest3 {
    //定义一个返回值是函数式接口Comparator的方法
    public static Comparator<String> getComparator(){
//        //方法返回值是一个接口，所以我们可以返回这个接口的匿名内部类
//        return new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2){
//                //按照字符串长度进行降序排序
//                return o2.length()-o1.length();
//            }
//        };
        //方法返回值是一个函数式接口，所以我可以返回一个Lambda表达式
        return (o1, o2)->{
            return o2.length()-o1.length();
        };
    }
    public static void main(String[] args) {
        String[] arr={"aaa","b","cccccc","ddddd"};
        //排序前的数组
        System.out.println(Arrays.toString(arr));
        //重新进行排序
        Arrays.sort(arr,getComparator());
        //排序后的数组
        System.out.println(Arrays.toString(arr));

    }
}
