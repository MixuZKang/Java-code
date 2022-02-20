package com.mixu.test.FunctionalInterface.demo1;
/*
* 函数式接口作为参数：
* 使用函数式接口作为方法参数传递，仅仅是把参数传递到showLog方法中
* 只有满足条件(日志等级为1)时才会调用接口中的方法，才会拼接字符串
* 如果不满足则不会调用接口中的方法也不会拼接字符串，所以不存在性能的浪费
* */
public class LambdaTest2 {
    public static void main(String[] args) {
        String msg1="hello";
        String msg2="world";
        String msg3="java";
        //这里日志的等级不是1，不会输出拼接后的字符串，但还是拼接了，浪费了性能
        showLog(2,msg1+msg2+msg3);
        //调用showLog，它的参数MessageBuilder是个函数式接口所以可以使用Lambda表达式
        showLog2(2,()->{
            //返回一个拼接好的字符串
            return msg1+msg2+msg3;
        });
    }

    //定义一个显示日志的方法，但是此方法会浪费性能
    public static void showLog(int level,String message){
        if (level==1){
            System.out.println(message);
        }
    }
    //定义一个显示日志的方法，方法的参数传递日志的等级和MessageBuilder接口
    public static void showLog2(int level,MessageBuilder msg){
        //判断如果是1级则调用接口中的方法
        if(level==1){
            System.out.println(msg.buliderMessage());
        }
    }

}
