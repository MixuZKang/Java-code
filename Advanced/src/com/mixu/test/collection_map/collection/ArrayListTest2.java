package com.mixu.test.collection_map.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListTest2 {
    //随机生成六个数，按照自己定义的方式打印
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            list.add(random.nextInt(50) + 1);
        }
        printArray(list);
    }

    //定义一个按照指定形式打印数组的方法
    public static void printArray(List<Integer> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (i == list.size() - 1) {//如果元素是最后一个
                System.out.println(num + "}");
            } else {
                System.out.print(num + "、");
            }
        }

    }
}
