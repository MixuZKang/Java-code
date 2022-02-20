package cn.mixu.test.Array;

//求数组最大值
public class MaxArray {
    public static void main(String[] args) {
       int[] arr={1,54,32,10,215,358,101};
       int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
}
