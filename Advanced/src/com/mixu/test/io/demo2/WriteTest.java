package com.mixu.test.io.demo2;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTest {
    public static void main(String[] args) throws IOException {
        //字符流的续写跟字节流一样加上参数true就可以续写了
        FileWriter fw=new FileWriter("E:\\study\\myshare\\b.txt");
        char[] chars={'a','b','c','d','e'};
        //写入一个字符数组
        fw.write(chars);
        fw.write("东非大裂谷");
        //把缓冲区中的数据刷新到文件中，流可以继续使用
        fw.flush();
        //传入一个字符数组，从索引1往后写入3个字符
        fw.write(chars,1,3);
        //传入一个字符串，从索引2往后写入3个字符
        fw.write("东非大裂谷",2,3);
        //把缓冲区中的数据刷新到文件中，关闭流
        fw.close();
    }
}
