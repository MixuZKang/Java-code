package com.mixu.test.io.file;

import java.io.File;
import java.io.IOException;

public class FileTest2 {
    public static void main(String[] args) throws IOException {
        File f1=new File("E:\\study\\myshare\\a.txt");
        //创建文件，如果存在就不会创建,返回true则创建成功
        System.out.println(f1.createNewFile());
        //删除文件或文件夹，文件夹里有内容的话不会删除返回false
        System.out.println(f1.delete());
        System.out.println("================");

        File f2=new File("E:\\study\\myshare\\aaa\\bbb");
        //创建文件夹
        System.out.println(f2.mkdirs());
        System.out.println("================");

        //遍历目录
        File f3=new File("E:\\study\\myshare\\");
        //方法一：返回一个String类型的数组，遍历数组，输出相对路径
        String[] list = f3.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("================");
        //方法二：返回一个File类型的数组，遍历数组，输出绝对路径
        File[] files = f3.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
