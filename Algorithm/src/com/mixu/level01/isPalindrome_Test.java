package com.mixu.level01;

import org.junit.Test;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如 121 是回文，而 123 不是。
public class isPalindrome_Test {

    @Test
    public void test(){
        System.out.println(isPalindrome(-12321));
    }


    public static boolean isPalindrome(int x) {
        int result = 0;
        //由于需要对传入的数进行和反转后的数进行比较，在反转过程中需要对传入的数进行除法运算
        //这样就无法保证传入的数为原值，所以把 x 赋给了 num，让 num 代替 x 进行除法运算
        int num = x;
        while (num > 0) {
            int temp = num % 10;
            result = result * 10 + temp;
            num = num / 10;
        }
        if(result == x){
            return true;
        }
        return false;
    }
}
