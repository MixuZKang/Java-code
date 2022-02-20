package com.mixu.test.io.demo2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        //创建字符缓冲输出流对象，构造方法里面传递字符输出流
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\study\\myshare\\bw.txt"));
        for (int i = 0; i < 5; i++) {
            bw.write("你好");
            //用BufferedWriter的特有方法newLine()实现换行
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
