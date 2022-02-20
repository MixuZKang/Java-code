package com.mixu.sort;

import org.junit.Test;

import java.util.Arrays;

//选择排序，时间复杂度 O(n^2)
public class SelectSortTest {

    @Test
    public void test() {
        int[] arr = {15, 8, 50, 6, 1};
        selectSort(arr);
    }

    public static int[] selectSort(int[] arr) {
        //每进行一次外循环相当于找到当前最小的数并与数组首位进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;//假定最小值的下标为数组首位（首轮排序为0）
            //之所以j = i + 1，是因为每一次循环过后都能找到当前循环的最小值并把他放到数组首位，所以没必要再判断之前替换过的
            for (int j = i + 1; j < arr.length; j++) {
                //如果条件成立说明当前定义的min不是真正的最小值
                if (arr[j] < min) {
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            //如果minIndex==i则说明当前最小值就为数组首位的数，没必要交换
            //如果minIndex!=i则说明数组首位并不是真正的最小值，则将上面找到的最小值与数组首位进行交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

}
