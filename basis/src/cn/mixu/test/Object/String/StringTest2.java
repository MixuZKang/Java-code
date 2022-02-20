package cn.mixu.test.Object.String;

import java.util.Scanner;

public class StringTest2 {
    public static void main(String[] args) {
        //键盘输入，判断字符串中大写、小写、数字、其他字符分别有多少个
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String next = sc.next();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;
        char[] chars = next.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if('A'<=ch&&ch<='Z'){
                countUpper++;
            }else if(('a'<=ch&&ch<='z')){
                countLower++;
            }else if(('0'<=ch&&ch<='9')){
                countNumber++;
            }else {
                countOther++;
            }
        }
        System.out.println("大写字母有："+countUpper);
        System.out.println("小写字母有："+countLower);
        System.out.println("数字有："+countNumber);
        System.out.println("其他字符有："+countOther);
    }
}
