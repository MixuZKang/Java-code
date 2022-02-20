package cn.mixu.test.Object.String;


/*
  * 由于String的值是不可变的，这就导致每次对String进行新增/更改操作都会生成新的String对象
    这样不仅效率低下，而且大量浪费有限的内存空间，所以我们使用缓冲区来增强性能
  * StringBuffer 和 StringBuilder 的实现能够被多次的修改，并且不产生新的未使用对象
  * StringBuffer 和 StringBuilder 的区别
       1.StringBuffer是线程安全的  StringBuilder是线程不安全的
           因为StringBuffer的所有公开方法都是synchronized修饰的，而StringBuilder并没有
           所以StringBuilder的性能是要大于StringBuffer的
       2.StringBuffer适合在多线程操作同一个缓冲区的场景，如果是单线程使用StringBuilder更合适
*/

public class StringBuilderTest {
    public static void main(String[] args) {
        //创建字符串缓冲区
        StringBuilder stringBuilder = new StringBuilder("string");
        //追加写入数据
        stringBuilder.append("Build").append("er").append(1);
        System.out.println(stringBuilder);
        //把字符串缓冲区转变成字符串
        String s = stringBuilder.toString();
        System.out.println(s);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("stringBuffer");
        System.out.println(stringBuffer);
    }
}

