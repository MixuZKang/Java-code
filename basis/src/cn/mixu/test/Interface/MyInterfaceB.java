package cn.mixu.test.Interface;

public interface MyInterfaceB {
    void methodB();

    void method();

    default void deMethod() {
        System.out.println("这是一个默认方法,默认方法也可以被实现类重写");
    }
}
