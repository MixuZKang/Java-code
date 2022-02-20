package com.mixu.test.collection_map.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
   Map集合：是一个双列集合，一个元素包含两个值(key，value)
     key和value的数据类型可以相同，也可以不同
     key是不允许重复的，value是可以重复的
     key和value是一一对应的
   Map.Entry<K,V>：在Map接口中有一个内部接口Entry
     当Map集合一创建，那么就会在Map集合中创建一个Entry对象，
     用来记录键与值(键值对对象，键与值的映射关系)-->结婚证
*/
public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");
        map.put(4,"冠希");
        map.remove(4);
        System.out.println(map);
        //通过key获取对应的值
        System.out.println(map.get(2));
        //判断是否包含
        System.out.println(map.containsKey(4));
        //遍历map集合1
        //通过keySet()把key存储到set集合中
        Set<Integer> in = map.keySet();
        //遍历set集合
        for (Integer key : in) {
            //通过key获取值
            String value = map.get(key);
            System.out.println("["+key+":"+value+"]");
        }

        //遍历map集合2
        //把Map里的Entry键值对对象放在set集合中
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //遍历set集合
        for (Map.Entry<Integer, String> entry : set) {
            //获取key
            Integer key = entry.getKey();
            //获取value
            String value = entry.getValue();
            System.out.println("["+key+":"+value+"]");
        }
    }
}
