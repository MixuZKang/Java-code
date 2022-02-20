package com.mixu.test.io.demo5;





import com.mixu.test.io.demo4.Person;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        ArrayList<String> one=new ArrayList<>();
        one.add("迪丽热巴");
        one.add("娜扎");
        one.add("张一一");
        one.add("李二二");
        one.add("王五五");
        one.add("迪巴巴");
        //把名字为3个字存储的一个新的集合中，然后只要前3人
        Stream<String> oneStream = one.stream().filter((name)->{
            return name.length()==3;
        }).limit(3);

        ArrayList<String> two=new ArrayList<>();
        two.add("迪丽热巴");
        two.add("娜扎");
        two.add("张三三");
        two.add("张四四");
        two.add("张五五");
        two.add("张六六");
        //把姓张的存储到一个新的集合中，不要前2人
        Stream<String> twoStream = two.stream().filter((name)->{
            return name.startsWith("张");
        }).skip(2);
        //把两个流合并，然后根据姓名创建Person对象存储到一个新的集合中，最后打印集合
        Stream.concat(oneStream,twoStream).map((name)->{
            return new Person(name);
        }).forEach((name)->{
            System.out.println(name);
        });
    }
}
