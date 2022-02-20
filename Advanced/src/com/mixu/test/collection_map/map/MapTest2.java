package com.mixu.test.collection_map.map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//输入一个字符串，计算字符串中每个字符出现的次数
public class MapTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //创建一个Map集合key为字符，value为字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        //遍历输入的字符串，把输入的字符串转化为字符，获取每一个字符
        for (char key : str.toCharArray()) {
            //使用获取到的字符判断Map集合中key是否存在
            if(map.containsKey(key)){
                //key存在则value++
                Integer value = map.get(key);
                value++;
                map.put(key,value);
            }else{
                //key不存在则添加进map集合
                map.put(key,1);
            }
        }
        //遍历Map集合
        Set<Character> set = map.keySet();
        for (Character key : set) {
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
    }

}
