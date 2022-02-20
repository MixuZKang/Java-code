package cn.mixu.test.Array;

import java.util.Arrays;

//对随机字符串进行升序排序，然后倒序打印
public class ArrayPractise {
    public static void main(String[] args) {
        String str = "bcadfeg45321";
        //把字符串转变为char类型的数组
        char[] chars = str.toCharArray();
        //把数组进行升序排序
        Arrays.sort(chars);
        System.out.println(chars);
        //把排序好的数组进行倒序打印
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
