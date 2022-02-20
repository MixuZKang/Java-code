package com.mixu;

import org.junit.Test;

public class RecursionTest {

    @Test
    public void test(){
        System.out.println(getSum(100));
        System.out.println(JieCheng(10));
    }

    //递归计算1到n的和
    public static int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + getSum(n - 1);
    }

    //递归计算阶乘
    public static int JieCheng(int n) {
        if (n == 1) {
            return 1;
        }
        return n * JieCheng(n - 1);
    }

}
