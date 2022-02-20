package cn.mixu.test.Object.integer;

import java.util.ArrayList;

public class IntegerTest {
    public static void main(String[] args) {
        //装箱
        Integer integer = new Integer(123);
        System.out.println(integer);
        Integer integer1 = Integer.valueOf(456);
        System.out.println(integer1);
        //拆箱
        int i = integer.intValue();
        System.out.println(i);
        System.out.println("============");
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);//自动装箱 相当于list.add(new Integer(1));
        int a = list.get(0);//自动拆箱 相当于list.get(0).intValue();
        System.out.println(a);
    }
}
