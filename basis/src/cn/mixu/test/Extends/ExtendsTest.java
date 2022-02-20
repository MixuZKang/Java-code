package cn.mixu.test.Extends;

public class ExtendsTest {
    public static void main(String[] args) {
        Zi z = new Zi();
        System.out.println("-----------构造完成-----------");
        z.method();
        System.out.println("-----------method()-----------");
        //如果子类没有重写show()则直接调用父类的，重写了则调用子类的
        z.show();
        System.out.println("-----------show()-----------");

    }
}
