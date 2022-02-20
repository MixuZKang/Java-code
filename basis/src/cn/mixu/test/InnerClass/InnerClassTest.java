package cn.mixu.test.InnerClass;

public class InnerClassTest {
    public static void main(String[] args) {
        Body b = new Body();
        //通过外部类对象间接调用内部类
        b.method();
        System.out.println("=============");
        //直接调用内部类
        Body.Heart h = new Body().new Heart();
        h.beat();
        System.out.println("=============");
        //通过成员方法调用局部内部类
        b.methodOuter();
        //如果成员内部类定义为静态static的，那么可以直接new Body.Heart()，且允许在静态成员内部类中定义静态资源

    }
}
