package com.mixu.test.reflection;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 写一个“框架”，在不改变任何代码的前提下可以创建任意类的对象，并且执行其中任意方法：
*   1、配置文件
*   2、反射
*   方法回顾：
*       load方法是把硬盘中保存的文件读取到内存中使用，参数传递一个字节或字符输入流
*       getProperty方法是通过键获取值
*       forName方法是用于获取Class对象，参数传递全类名
* */
public class classTest {
    public static void main(String[] args) throws Exception {
        //创建Properties对象
        Properties pro =new Properties();
        //获取类加载器
        ClassLoader classLoader = classTest.class.getClassLoader();
        //使用类加载器里的getResourceAsStream方法获取资源对应的字节流
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        //使用load方法获取配置文件，参数传递一个字节输入流
        pro.load(is);
        //获取配置文件里的数据
        //获取全类名，通过key获取value
        String className = pro.getProperty("className");
        //获取方法名
        String methodName = pro.getProperty("methodName");
        //加载该类进内存
        Class cls = Class.forName(className);
        //获取Class对象之后，就可以创建对象
        Object obj = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
