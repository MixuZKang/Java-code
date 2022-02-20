package com.mixu.test.io.demo3;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

//Properties是一个属性集，它可以保存到流中或从流中加载
public class PropertiesTest {


    @Test
    public void show01() {
        Properties p=new Properties();
        p.setProperty("张三","155");
        p.setProperty("李四","180");
        p.setProperty("王五","172");
        //用stringPropertyNames()方法把Properties里的key取出来放在一个set集合中
        Set<String> strings = p.stringPropertyNames();
        //遍历set集合
        for (String key : strings) {
            //使用getProperty通过key获取value
            String value = p.getProperty(key);
            System.out.println(key+"="+value);
        }
    }

    @Test
    public void show02() throws IOException {
        Properties p=new Properties();
        p.setProperty("张三","155");
        p.setProperty("李四","180");
        p.setProperty("王五","172");
        //创建字节或字符输出流，构造方法绑定要输出的目的地
        FileWriter fw=new FileWriter("E:\\study\\myshare\\prop.txt");
        //使用store方法把集合中的临时数据存储到硬盘中,参数传递一个字节或字符输出流和注释
        p.store(fw,"123");
        fw.close();
        //如果使用字节流不能写中文
        //p.store(new FileOutputStream("E:\\study\\myshare\\prop.txt"),"");
    }

    @Test
    public void show03() throws IOException {
        Properties p=new Properties();
        //使用load方法把硬盘中保存的文件读取到集合中使用，参数传递一个字节或字符输入流
        p.load(new FileReader("E:\\study\\myshare\\prop.txt"));
        Set<String> strings = p.stringPropertyNames();
        //遍历set集合
        for (String key : strings) {
            //使用getProperty通过key获取value
            String value = p.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
}
