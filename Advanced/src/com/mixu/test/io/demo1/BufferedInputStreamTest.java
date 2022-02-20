package com.mixu.test.io.demo1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\study\\myshare\\Bfout.txt");
        //创建一个字节缓冲输入流给FileInputStream增加一个缓冲区，提高读取效率
        BufferedInputStream bis = new BufferedInputStream(fis);
        //如果再使用数组缓冲的话效率会更高
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        bis.close();
    }
}
