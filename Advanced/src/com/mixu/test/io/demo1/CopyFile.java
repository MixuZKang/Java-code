package com.mixu.test.io.demo1;

import java.io.*;

//通过流的方式复制文件到指定的目录
public class CopyFile {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输入流和输出流提高程序效率
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\study\\myshare\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\study\\myshare\\copy.txt"));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            //把读取到的数据写入
            bos.write(bytes, 0, len);
        }
        //需要先关输出流再关输入流，因为后进先出
        bos.close();
        bis.close();
    }
}
