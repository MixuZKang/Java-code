package com.mixu.test.FunctionalInterface.demo2;

import java.util.function.Supplier;

//使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组最大值
public class SupplierTest {
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr={1000,55,-55,8,6456,13};
        //调用方法里面参数是函数式接口，可以使用Lambda表达式重写get方法
        int value=getMax(()->{
            //获取最大值并返回
            int max=arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]>max){
                    //如果i大于max就把i替换为最大值
                    max=arr[i];
                }
            }
            return max;
        });
        System.out.println(value);
    }
}
