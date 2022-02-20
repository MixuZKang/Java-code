package com.mixu.test.io.demo3;

import java.io.*;

/*
* 可以使用转换流来转换文件的编码：
* 1、创建一个转换输入流来读取一个GBK的文本文件
* 2、再创建一个转换输出流把读取到的文件写成一个UTF-8的文本文件
* */
public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        //创建转换输出流对象，构造方法中传递字节输出流和指定的编码表
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("E:\\study\\myshare\\utf8.txt"),"utf-8");
        osw.write("你好啊");
        osw.flush();
        osw.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(""));
    }
}
