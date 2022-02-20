package com.mixu.test.collection_map.map;



import com.mixu.test.collection_map.Person;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/*
  HashMap：是一个无序的集合，存储和取出的顺序不一致，HashMap底层是数组+链表+红黑树
    HashMap存储自定义类型pojo的键值：
      Map集合必须保证key是唯一的，所以自定义类型如果作为key，则必须要重写equals和hashCode方法

  LinkedHashMap：key不允许重复，但存储和取出的顺序一致
 */
public class HashMapTest {
    public static void main(String[] args) {
        //HashMap:key不允许重复，无序
        HashMap<Person,String> map=new HashMap<>();
        map.put(new Person("张三",18),"深圳");
        map.put(new Person("李四",25),"上海");
        map.put(new Person("王五",80),"北京");
        map.put(new Person("张三",18),"广州");
        Set<Person> set = map.keySet();
        for (Person key : set) {
            String value = map.get(key);
            System.out.println(key+"-->"+value);
        }
        //LinkedHashMap:key不允许重复，有序
        LinkedHashMap<Integer,String> linked=new LinkedHashMap<>();
        linked.put(1,"a");
        linked.put(2,"b");
        linked.put(3,"c");
        System.out.println(linked);
    }
}
