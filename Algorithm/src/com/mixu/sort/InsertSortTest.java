package com.mixu.sort;

import org.junit.Test;

import java.util.Arrays;

//插入排序
public class InsertSortTest {

    @Test
    public void test() {
        int[] arr = {101, 34, 80, 1};
        insertSort(arr);
    }

    //首先把数组中的第一个数放到“有序表”中，随后把数组中另外的数与“有序表”中的数进行比较并插入
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义待插入“有序表”中的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[i]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置时不越界
            // 2. insertVal < arr[insertIndex] 待插入的数小于前一位，代表暂时还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移一位 [101, 34, 80, 1] ---> [101, 101, 80, 1]
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;//为了跟前面所有的数进行比较，比到下标为0的数为止
            }
            // 当退出while循环时，说明插入的位置已找到
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                //[101, 101, 80, 1] ---> [34, 101, 80, 1]
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }

    }
}
