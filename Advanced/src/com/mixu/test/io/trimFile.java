package com.mixu.test.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

//更改文件内容，去除换行
public class trimFile {

    @Test
    public void show() {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream("E:\\study\\myshare\\data.txt");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, len));
            }
            String[] split = builder.toString().split("\r\n");
            for (String str : split) {
                if (!str.isEmpty()){
                    System.out.println(str);
                }
                /*String trim = str.trim();
                if (!trim.isEmpty()) {
                    System.out.println(trim);
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
