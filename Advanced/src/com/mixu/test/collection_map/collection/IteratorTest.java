package com.mixu.test.collection_map.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//演示迭代器
public class IteratorTest {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        //获取迭代器遍历集合
        Iterator<String> it = coll.iterator();
        //判断集合中是否有下一个元素，快捷键 itit
        while (it.hasNext()) {
            //使用next()方法把游标向后移一位并把元素取出
            Object obj = it.next();
            System.out.println("迭代器：" + obj);
        }
        //或者使用增强for循环，底层其实还是使用迭代器来实现遍历，快捷键 I
        for (String s : coll) {
            System.out.println("foreach：" + s);
        }

    }
}
