package com.mixu.test.io.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//readLine:是BufferedReader的特有方法，读取一行数据，返回该行内容的字符串，如果读到末尾则返回null
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("E:\\study\\myshare\\bw.txt"));
        String line="";
        //方法的返回值line可以理解为等效于read()的返回值len
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
}
