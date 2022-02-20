package com.mixu.test.collection_map.collection;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.addFirst("WWW");//在集合开头添加元素
        System.out.println(linked.getFirst());//返回第一个元素
        System.out.println(linked.getLast());//返回最后一个元素
        linked.removeFirst();//移除第一个元素
        linked.removeLast();//移除最后一个元素
        System.out.println(linked);
        linked.clear();//清空元素
    }
}
