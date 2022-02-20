package cn.mixu.test.Interface;

public interface MyInterfaceC extends MyInterfaceA,MyInterfaceB{
    @Override
    default void deMethod() {
        //如果一个接口继承了另外两个接口，且这两个接口中的默认方法名重复了，则此接口要重写默认方法
        System.out.println("ABC");
    }
    void methodC();
}
