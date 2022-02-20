package com.mixu.test.io.demo3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        //创建转换输入流对象，构造方法中传递字节输入流和指定的编码表
        InputStreamReader isr=new InputStreamReader(new FileInputStream("E:\\study\\myshare\\utf8.txt"),"utf-8");
        int len=0;
        while((len=isr.read())!=-1){
            System.out.print((char)len);
        }
        isr.close();
    }
}
