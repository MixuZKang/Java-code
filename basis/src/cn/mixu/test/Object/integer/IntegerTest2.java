package cn.mixu.test.Object.integer;

public class IntegerTest2 {
    public static void main(String[] args) {
        //基本类型-->字符串
        String s1 = 100 + "";//会这一种即可
        System.out.println(s1 + 300);

        String s2 = Integer.toString(100);
        System.out.println(s2 + 300);

        String s3 = String.valueOf(100);
        System.out.println(s3 + 300);
        //字符串-->基本类型
        int i = Integer.parseInt("100");
        System.out.println(i + 300);
        Integer integer = Integer.valueOf("100");
        System.out.println(integer + 300);


        System.out.println("=========================");
        //赋-128到127之间的数值会取缓存里的已有的，如果超过这个范围才会new一个新的Integer对象
        Integer integer1 = 100;
        Integer integer2 = 100;
        Integer integer3 = new Integer(100);
        System.out.println(integer1==integer2);//true
        System.out.println(integer1==integer3);//因为手动new了，所以返回false

        Integer integer4 = 800;
        Integer integer5 = 800;
        System.out.println(integer4==integer5);//超过了-128到127这个范围则会new一个新的，所以返回false

        int i1 = 100;
        //只要有基本类型，那么“==”就相当于判断值是否相等，包装类会自动向下转型与基本类型进行比较
        System.out.println(i1 == integer1);//True
    }
}
