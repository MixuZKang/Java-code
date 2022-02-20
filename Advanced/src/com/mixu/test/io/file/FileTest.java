package com.mixu.test.io.file;

import java.io.File;

/*路径：
    绝对路径：完整的路径
        以盘符(C:  D:)开始 E:\\study\\a.txt
    相对路径：简化的路径
        E:\\study\\a.txt ---> a.txt
    路径分隔符： windows ; Linux :
    文件名称分隔符： windows \ Linux /
* */
public class FileTest {
    public static void main(String[] args) {
        show1("c:\\","a.txt");
        show2();
    }

    private static void show1(String p,String c) {
        File file=new File(p,c);
        System.out.println(file);
    }

    private static void show2() {
        File f1=new File("E:\\study\\IntelliJ IDEA 2018.1.8");
        //获取绝对路径
        System.out.println(f1.getAbsolutePath());
        //获取路径
        System.out.println(f1.getPath());
        //获取路径的结尾
        System.out.println(f1.getName());
        //路径必须存在否则都返回false，所以要判断路径是否存在
        if(f1.exists()){
            //判断路径是否以文件夹结尾
            System.out.println(f1.isDirectory());
            //判断路径是否以文件结尾
            System.out.println(f1.isFile());
        }

        File f2=new File("E:\\study\\myshare\\hello.txt");
        //获取文件的大小
        System.out.println(f2.length());
    }
}
