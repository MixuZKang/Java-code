package com.mixu.test.collection_map.collection;

import java.util.ArrayList;
import java.util.Collections;

//collections是集合的工具类
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        //添加多个
        Collections.addAll(list,1,2,3,4,5,6);
        System.out.println(list);
        //打乱集合
        Collections.shuffle(list);
        System.out.println(list);
        //排序集合
        Collections.sort(list);
        System.out.println(list);
        //反转集合
        Collections.reverse(list);
        System.out.println(list);
    }
}
