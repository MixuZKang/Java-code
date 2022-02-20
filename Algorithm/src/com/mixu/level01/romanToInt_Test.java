package com.mixu.level01;

import org.junit.Test;

public class romanToInt_Test {

    @Test
    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            int value = getValue(s.charAt(i));
            //i最大只能为倒数第二个数的索引，如果i为最后一个数的索引，这时再取下一个数就会越界，要让 i<=n-2 防止字符串下标越界
            //即“MCMXCIV”，长度为7，索引i必须小于等于 7-2，也就是i最大只能为 5（索引从0开始，所以要长度-2）
            //并判断当前值如果小于下一值，则相减，如罗马数字“IV”为4，即 1-5
            if (i <= n - 2 && value < getValue(s.charAt(i + 1))) {
                num -= value;
            } else {
                num += value;
            }

        }
        return num;
    }

    //也可以用Map，但使用Switch获取值的速度快，因为不需要去查hash表
    public static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
