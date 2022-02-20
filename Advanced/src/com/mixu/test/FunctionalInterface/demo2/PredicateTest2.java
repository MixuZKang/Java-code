package com.mixu.test.FunctionalInterface.demo2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest2 {
    /*
    * 定义一个方法，参数传递一个包含人员信息的数组
    * 传递两个Predicate接口，对数组中的信息进行过滤
    * 把满足条件(姓名为4个字，性别为女)的信息存到ArrayList集合中返回
    * */
    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2){
        //创建一个集合存储过滤后的信息
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            //对获取到的字符串进行判断
            boolean b = pre1.and(pre2).test(s);
            if(b){
                //如果条件成立就把信息存储到集合中
                list.add(s);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String[] array={"张三,男","李四五六,女","迪丽热巴,女","王八九十,男"};
        ArrayList<String> arr=filter(array,(String str)->{
            //获取字符串的性别，判断是否为女
            return str.split(",")[1].equals("女");
        },(String str)->{
            //获取字符串的姓名，判断长度是否为4
            return str.split(",")[0].length()==4;
        });
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
