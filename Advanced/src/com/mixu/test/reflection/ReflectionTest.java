package com.mixu.test.reflection;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/*反射：将类的各个组成部分封装为其他对象，这就是反射机制
    好处：
       1.可以在程序运行过程中，操作这些对象。
       2.可以解耦，提高程序的可扩展性。
*/
public class ReflectionTest {


    @Test
    public void test01() throws Exception {
        //方式一：使用Class.forName("全类名")的方式获取，将字节码文件加载进内存，返回 Class对象(多用于配置文件)
        Class aClass = Class.forName("cn.mixu.test.reflection.Person");
        System.out.println(aClass);
        //方式二：使用类名.class的方式获取 Class对象(多用于参数的传递)
        Class aClass1 = Person.class;
        System.out.println(aClass1);
        //方式三：使用对象.getClass()的方式获取 Class对象(已有对象，通过对象获取字节码的方式)
        Person p1 = new Person();
        Class aClass2 = p1.getClass();
        System.out.println(aClass2);

        //不论通过哪一种方式获取的Class对象都是同一个
        System.out.println(aClass==aClass1);//true
        System.out.println(aClass==aClass2);//true
        //方式四：使用类加载器的方式获取(了解即可)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class aClass3 = classLoader.loadClass("cn.mixu.test.reflection.Person");
        System.out.println(aClass3);
    }

    //回忆加载配置文件的方式
    @Test
    public void test02() throws Exception {
        Properties pros = new Properties();
        //方式一：配置文件位置默认在当前的module下
        //pros.load(new FileInputStream("jdbc.properties"));
        //方式二：使用类加载器，配置文件位置默认在当前的module里的src下
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user:"+user+" password:"+password);
    }
}
