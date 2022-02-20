package cn.mixu.test.Object.String;

import org.junit.Test;

public class StringTest {

    //equals：比较
    @Test
    public void show01(){
        String str1 = "Hello";
        char[] array = {'H', 'e', 'l', 'l', 'o'};
        String str2 = new String(array);
        System.out.println(str1.equals(str2));
    }

    //length：获取字符串长度
    @Test
    public void show02(){
        int length = "ssssssssssssssssssss".length();
        System.out.println("字符串长度为：" + length);
    }

    //concat：字符串拼接
    @Test
    public void show03(){
        String str1 = "hello";
        String str2 = "world";
        System.out.println(str1.concat(str2));
    }

    //charAt/indexOf：按照索引获取
    @Test
    public void show04(){
        //获取指定索引位置的参数
        char c = "HelloWorld".charAt(5);
        System.out.println("索引为5的字符是：" + c);
        //获取指定参数第一次出现的索引位置，没有找到则返回 -1
        String str = "HelloWorld";
        int index = str.indexOf("or");
        System.out.println("第一次出现的索引为：" + index);
    }

    //substring：截取字符串
    @Test
    public void show05(){
        String str = "helloWorld";
        System.out.println("截取：" + str.substring(3));
        System.out.println("截取：" + str.substring(4, 7));
    }

    //toCharArray/getBytes：字符串转为数组
    @Test
    public void show06(){
        //转为字符数组
        char[] chars = "hello".toCharArray();
        System.out.println("字符数组长度为：" + chars.length);
        //转为字节数组
        byte[] bytes = "abcd".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
    }

    //replace：替换
    @Test
    public void show07(){
        String str = "How do you do";
        String replace = str.replace("o", "!");
        System.out.println(replace);

    }

    //split：分割字符串
    @Test
    public void show08(){
        String str = "aaa,bbb,ccc";
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    //trim：去掉字符串头尾的空格
    @Test
    public void show09(){
        String str = " 12 3 ";//只能去除头尾空格，不能去除中间的
        System.out.println(str.trim());
    }
}
