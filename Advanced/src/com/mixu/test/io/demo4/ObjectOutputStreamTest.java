package com.mixu.test.io.demo4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
*   对象序列化流：可以把对象保存到流中或从流中加载
*   1.要进行序列化和反序列化的类必须实现Serializable接口
*   2.被静态修饰的成员变量是不能被序列化的，因为静态不属于对象
*   3.如果不想成员被序列化可以加一个transient瞬态关键字来修饰那个成员
*   4.由于每次修改要序列化的类，序列号都会发生改变，从而导致反序列化异常，所以需要自己定义一个永远不会发生改变的序列号
*/
public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\study\\myshare\\obj.txt"));
        //用对象序列化输出流的特有方法来写入一个对象
        oos.writeObject(new Person("冠希",18));
        oos.close();
    }
}
