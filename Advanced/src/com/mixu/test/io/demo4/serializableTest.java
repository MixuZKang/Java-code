package com.mixu.test.io.demo4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//当需要在文件中存储多个对象时，可以把多个对象存储到一个集合中，然后再对集合进行序列化和反序列化
public class serializableTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> list=new ArrayList<>();
        list.add(new Person("张三",18));
        list.add(new Person("李四",18));
        list.add(new Person("王五",20));
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\study\\myshare\\collection.txt"));
        oos.writeObject(list);
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\study\\myshare\\collection.txt"));
        Object obj = ois.readObject();
        //把Object类型的集合强转成ArrayList类型的集合
        ArrayList<Person> list2=(ArrayList<Person>)obj;
        for (Person person : list2) {
            System.out.println(person);
        }
        ois.close();
        oos.close();
    }
}
