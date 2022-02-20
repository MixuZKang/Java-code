package cn.mixu.test;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class test01 {

    @Test
    public void show(){
        String str1 = "abcsss";
        String str2 = "abc";
        int result = str1.compareTo(str2);
        System.out.println(result);
    }

}
