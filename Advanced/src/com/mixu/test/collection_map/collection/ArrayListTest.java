package com.mixu.test.collection_map.collection;

import java.util.ArrayList;
import java.util.Random;

//用一个大集合存入20个随机数字，然后筛选其中偶数存到一个小集合中
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(50) + 1;
            bigList.add(num);
        }
        ArrayList<Integer> list = getSmallList(bigList);
        System.out.println("一共有" + list.size() + "个偶数");
        System.out.println(list);
    }

    //定义一个方法，传入一个集合筛选其中的偶数元素并存入一个新集合返回
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList) {
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);
            if (num % 2 == 0) {
                smallList.add(num);
            }
        }
        return smallList;
    }
}
