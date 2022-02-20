package cn.mixu.test.Array;

/*
  可变参数：确定数据类型，但是参数个数不确定就可以用
    如果方法参数有多个，那么可变参数要写在参数列表的最后面，
    如：(String str1,String str2,int...arr)
*/
public class VarArgsTest {
    public static void main(String[] args) {
        int add = add(50, 60, 85, 200);
        System.out.println(add);
    }

    //定义一个传递任意个数的数字并把它们相加的方法
    public static int add(int...arr){
        int sum=0;
        for (int i : arr) {
            //sum=sum+i;
            sum+=i;
        }
        return sum;
    }
}
