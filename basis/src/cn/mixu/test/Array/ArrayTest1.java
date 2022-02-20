package cn.mixu.test.Array;

//反向遍历数组
public class ArrayTest1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(array);
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp;
            temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        printArray(array);
    }

    //定义一个打印数组的方法
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
