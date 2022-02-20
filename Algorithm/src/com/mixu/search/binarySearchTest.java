package com.mixu.search;

import org.junit.Test;

//折半/二分查找
public class binarySearchTest {

    @Test
    public void test() {
        int[] arr = {1, 5, 8, 15, 22, 35, 48, 64, 69, 88};
        int key = 69;
        int i = binarySearch(arr, key);
        System.out.println("元素" + key + "所对应数组的索引位置为：" + i);
    }

    //使用二分查找搜索一个数，如果存在，返回其索引，否则返回 -1。
    public static int binarySearch(int[] arr, int key) {
        int min;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            min = low + high / 2;
            if (key == arr[min]) {
                return min;
            //当我们发现索引mid不是要找的key时，下一步的搜索区间呢？
            //当然是 [low, mid - 1] 或者 [mid + 1, high] 因为mid已经搜索过，应该从搜索区间中去除。
            } else if (arr[min] > key) {
                high = min -1;
            } else if (arr[min] < key){
                low = min + 1;
            }
        }
        return -1;
    }


}
