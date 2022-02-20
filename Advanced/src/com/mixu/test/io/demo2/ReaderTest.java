package com.mixu.test.io.demo2;

import java.io.FileReader;
import java.io.IOException;

//用法跟InputStream几乎一样
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("E:\\study\\myshare\\a.txt");
        //创建一个字符缓冲区，用法跟字节输入流的字节缓冲区类似
        char[] chars = new char[1024];
        while (reader.read(chars) != -1) {
            System.out.print(new String(chars));
        }
    }
}
