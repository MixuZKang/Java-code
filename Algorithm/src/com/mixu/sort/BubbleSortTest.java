package com.mixu.sort;


import org.junit.Test;

import java.util.Arrays;

//冒泡排序，时间复杂度 O(n^2)
public class BubbleSortTest {

    @Test
    public void test() {
        int[] arr = {3, 9, 1, 10, 5};
        bubbleSort(arr);

    }

    public static int[] bubbleSortBetter(int[] arr) {
        int temp = 0;
        boolean flag = false;
        /*每进行一次外循环相当于找到一个最大的数并排序到数组最后
        之所以j < arr.length - 1 - i，是因为每当进行了一次外循环后，当前最大的数已经排序完成，不需要判断已经排序好的数
        */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序后的数组为：");
            System.out.println(Arrays.toString(arr));

            //优化：如果发现某趟排序中没有发生任何一次交换（代表已排序完成），可以提前结束排序
            //判断如果flag为false，则代表没有进到if里面进行交换排序，代表此时已经不需要再排序，可以提前结束退出
            if (!flag) {
                break;
            } else {
                //因为在if中把flag设为了true，需要重新设为false
                flag = false;
            }
        }
        return arr;
    }


    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序后的数组为：");
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

}
