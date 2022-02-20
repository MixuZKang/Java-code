package com.mixu.level01;

import org.junit.Test;

//编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 ""。
public class longestCommonPrefix_Test {

    @Test
    public void test() {
        String[] str = {"cir", "car"};
        System.out.println(longestCommonPrefix(str));
        System.out.println(niubi(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            //比较完一次如果找不到公共前缀则直接退出循环，没必要再判断之后的字符串
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    //我的解法
    public static String longestCommonPrefix(String str1, String str2) {
        int count = Math.min(str1.length(), str2.length());
        String prefix = "";
        for (int i = 0; i < count; i++) {
            char c = str2.charAt(i);
            if (str1.charAt(i) == c) {
                prefix += c;
            }
            String s = Character.toString(c);
            if (!prefix.contains(s)) {
                return prefix;
            }
        }
        return prefix;
    }

    //官方解法
    public static String longestCommonPrefix2(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    //大神解法
    public String niubi(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，随便选一个先
        String prefix = strs[0];
        for (String string : strs) {
            //判断当前字符串string是否以prefix字符串开头，如果不是则将prefix从尾部减去一个字符
            //直到string与prefix匹配则退出循环，并继续比较下一个字符串找出公共前缀
            while (!string.startsWith(prefix)) {
                if (prefix.length() == 0) return "";
                //公共前缀不匹配就让它变短
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
