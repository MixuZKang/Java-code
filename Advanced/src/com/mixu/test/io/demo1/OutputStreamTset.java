package com.mixu.test.io.demo1;

import java.io.FileOutputStream;

/*
     内存：临时存储   硬盘：永久存储
     input输入(读)：把硬盘中的数据读取到内存中使用
     output输出(写)：把内存中的数据写入到硬盘中保存
     流：数据(字符，字节) 1字符=2字节
                读           写
     字节流：InputStream OutputStream
     字符流：  Reader       Writer

  FileOutputStream：文件字节输出流，是一个往文件中写入数据的流
     windows的换行符号：\r\n
     Linux的换行符号：\n
*/
public class OutputStreamTset {
    public static void main(String[] args) throws Exception {
        //多加一个参数true则打开追加写开关
        FileOutputStream fos = new FileOutputStream("E:\\study\\myshare\\a.txt", false);
        byte[] data = {97, 98, 99, 100, 101, 102};
        fos.write(data);
        //getBytes可以把字符串转为字节数组
        fos.write("\r\n".getBytes());
        //截取写入，从索引0开始写入byte数组长度个字节（即全部写入）
        fos.write(data, 0, data.length);
        fos.write("\r\n".getBytes());
        for (int i = 0; i < 3; i++) {
            //使用String的getBytes方法把字符串转化为字节数组
            fos.write("中文".getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }
}
