package cn.mixu.test.Array;

import java.util.Arrays;

public class copyArray {
    public static void main(String[] args) {
        //数组如何扩容？
        //方式一：
        int[] arr = {1, 2, 3};
        //定义一个新的数组，长度为原来数组的大小加上需要扩充的大小
        int[] copyArr = new int[arr.length + 1];
        //把旧数组的元素添加到新数组中
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        //把要新添加的元素赋给copyArr的最后一个位置
        copyArr[copyArr.length - 1] = 4;
        //让arr指向扩容后的数组copyArr，相当于把copyArr的地址赋给了arr，原本的数组arr就被销毁了
        arr = copyArr;
        System.out.println("扩容后arr数组的情况：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        //方式二：
        //使用JDK提供的方法，复制旧数组的元素创建一个新数组并扩容，参数传入旧数组和复制后新数组的长度
        int[] arrNew = Arrays.copyOf(arr, 18);
        System.out.println('\n'+"==========");
        for (int i = 0; i < arrNew.length; i++) {
            System.out.print(arrNew[i]);
        }

    }
}
