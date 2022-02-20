package com.mixu.test.io.demo1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("E:\\study\\myshare\\Bfout.txt");
        //创建一个字节缓冲输出流给FileOutputStream增加一个缓冲区，提高程序效率
        BufferedOutputStream bos=new BufferedOutputStream(fos,1024);
        bos.write("你好你好好".getBytes());
        //为了防止数据丢失，把缓冲区中的数据提前刷新到文件中，流可以继续使用
        bos.flush();
        bos.close();
    }
}
