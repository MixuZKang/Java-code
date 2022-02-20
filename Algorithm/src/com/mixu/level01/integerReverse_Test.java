package com.mixu.level01;


import org.junit.Test;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] 即 [-2147483648,2147483647]，就返回 0。
public class integerReverse_Test {

    @Test
    public void test(){
        System.out.println(reverse(1534236469));
    }


    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            //取到最低位数字：12345 取5
            int temp = x % 10;
            //当反转后的值result大于最大值的十分之一时，还有temp需要添加则溢出：因为如果result为914748364，再添加任意temp必定溢出
            //当反转后的值result等于最大值的十分之一时，新添加的temp大于7则溢出：因为如果result为214748364，再添加8、9等数字会溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            //当反转后的值result小于最小值的十分之一时，还有temp需要添加则溢出：因为如果result为-914748364，再添加任意temp必定溢出
            //当反转后的值result等于最小值的十分之一时，新添加的temp小于-8则溢出：因为如果result为-214748364，再添加-9则会溢出
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
            x = x / 10;
        }
        return result;
    }

}
