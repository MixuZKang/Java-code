package com.mixu.test.io.demo1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/*
  FileInputStream：文件字节输入流，是一个读取文件中数据进内存的流
    read()：读取文件中的一个字节，并返回每次读取到的有效字节个数，读到末尾返回-1
    使用字节流读取中文字符会乱码，需要使用字符流
*/
public class InputStreamTset {

    //一次读取一个字节
    @Test
    public void show01() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\study\\myshare\\a.txt");
        //创建一个变量，记录读取到的字节
        int len = 0;
        //读取到的字节的有效个数len为-1时结束打印
        while ((len = fis.read()) != -1) {
            //把int类型转为char类型打印
            System.out.print((char) len);
        }
    }

    //一次读取多个字节
    @Test
    public void show02() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\study\\myshare\\a.txt");
        //创建一个缓冲区，存储读取到的多个字节
        byte[] bytes = new byte[1024];
        int len = 0;
        //从输入流中读取一定数量的字节，并将其存储到缓冲区数组中
        while ((len = fis.read(bytes)) != -1) {
            //用String的构造方法把字节数组的一部分转化成字符串
            System.out.print(new String(bytes, 0, len));
        }
        fis.close();
    }
}
