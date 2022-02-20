package com.mixu.test.io.demo2;

import java.io.FileWriter;
import java.io.IOException;

/*
    JDK7之前使用try/catch/finally处理流中的异常
    JDK7以后try后面可以加()在里面定义流对象
    JDK9以后try()里面可以直接引入定义好的流对象：
        FileWriter fw1 = new FileWriter    FileWriter fw2 = new FileWriter
        try(fw1,fw2){}catch(){}
*/
public class TryCatch {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("E:\\study\\myshare\\c.txt",true)){
            for (int i = 0; i < 5; i++) {
                fw.write(i + ":hello" + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
