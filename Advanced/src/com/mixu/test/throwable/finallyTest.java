package com.mixu.test.throwable;

import java.io.IOException;


public class finallyTest {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[2]);
            readFile("c:\\b.tx");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            //无论是否出现异常finally都会执行，为了避免代码逻辑混淆，尽量不要在这里面写return或者抛出异常
            System.out.println("资源释放");
        }
        System.out.println("test1："+test1());
        System.out.println("test2："+test2());
        test3();
    }

    public static void readFile(String fileName) throws IOException {
        //如果文件名不是以.txt结尾
        if (!fileName.endsWith(".txt")) {
            throw new IOException("后缀名不对");
        }
        System.out.println("路径正确");

    }

    /*方法运行返回 0：
    因为执行到try的return ret; 语句前会先将返回值ret保存在一个临时变量中，然后才执行finally语句
    最后try再返回那个临时变量，finally中对ret的修改不会被返回。
    */
    public static int test1(){
        int ret = 0;
        try{
            return ret;
        }finally{
            ret = 2;
        }
    }

    /*方法运行返回 2：
    因为5/0会触发ArithmeticException异常，但是finally中有return语句
    finally中return不仅会覆盖try/catch内的返回值且还会掩盖try/catch内的异常，就像异常没有发生一样，而且不再向上传递异常了
    也就是说当finally中没有return时该方法运行则会抛出ArithmeticException异常
    */
    public static int test2() {
        int ret = 0;
        try {
            int a = 5 / 0;
            return ret;
        } finally {
            return 2;
        }
    }

    //方法运行抛出hello异常，因为如果finally中抛出了异常，则原异常就会被掩盖。
    public static void test3() {
        try {
            int a = 5 / 0;
        } finally {
            throw new RuntimeException("hello");
        }
    }
}
