package com.mixu.test.io.file;

import java.io.File;
import java.io.FileFilter;

//创建FileFilter的实现类，重写过滤方法accept，定义过滤规则
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathName) {
        //如果是一个文件夹就返回true，继续遍历这个文件夹
        if(pathName.isDirectory()){
            return true;
        }
        //返回全部以.txt结尾的文件不区分大小写
        return pathName.toString().toLowerCase().endsWith(".txt");
    }
}
