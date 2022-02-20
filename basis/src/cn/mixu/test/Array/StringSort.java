package cn.mixu.test.Array;


//使用冒泡排序排序字符串
public class StringSort {
    public static void main(String[] args) {
        String str = "mopbzgedva";
        char[] chars = str.toCharArray();
        //只需要数组长度减一次循环就能排序完成
        for (int i = 0; i < chars.length - 1; i++) {
            //因为外循环每循环一次，就把当前最大的参数排序到了数组的最后面，那么再下一次排序就不需要对最后一个参数进行判断了
            //所以内循环结束条件为数组长度减去外循环的次数再减一
            for (int j = 0; j < chars.length - i - 1; j++) {
                char temp;
                //如果前面的参数大于后面的参数，则把前后参数调换位置
                if (chars[j] > chars[j + 1]) {
                    temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }
}
