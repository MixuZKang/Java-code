package com.mixu.test.io.demo4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\study\\myshare\\obj.txt"));
        //用对象序列化输入流的特有方法来读取文件里的对象
        Object o = ois.readObject();
        ois.close();
        //打印一下读取到的对象
        System.out.println(o);
    }
}
