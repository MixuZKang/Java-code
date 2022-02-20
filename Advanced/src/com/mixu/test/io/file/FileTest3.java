package com.mixu.test.io.file;

import java.io.File;
import java.io.FileFilter;

/*
   listFiles()一共做了3件事情：
     1.listFiles会对构造方法中传递的目录进行遍历，获取目录中的每一个文件/文件夹-->封装为File对象
     2.listFiles会调用参数传递的过滤器FileFilter的实现类的方法accept
     3.listFiles会把遍历得到的每一个File对象，传递给accept方法的参数pathName
*/
public class FileTest3 {
    public static void main(String[] args) {
        File file = new File("E:\\study\\myshare\\");
        getAllFile(file);
    }

    //递归遍历多级目录
    public static void getAllFile(File src) {
        File[] files = src.listFiles(new FileFilterImpl());
        for (File file : files) {
            //判断file是否是一个文件夹
            if (file.isDirectory()) {
                //getAllFile方法就是传递文件夹，遍历文件夹的方法
                //所有直接递归调用getAllFile方法即可
                getAllFile(file);
            } else {
                //如果f是一个文件，直接打印即可
                System.out.println(file);
            }
        }
    }

    //匿名内部类的方式
    public static void getAllFile2(File src) {
        File[] files = src.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.toString().toLowerCase().endsWith(".txt");
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }

    //Lambda表达式的方式
    public static void getAllFile3(File dir) {
        File[] files = dir.listFiles((File pathname) -> {
            return pathname.isDirectory() || pathname.toString().toLowerCase().endsWith(".txt");
        });
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFile(f);
            } else {
                System.out.println(f);
            }
        }
    }

}
