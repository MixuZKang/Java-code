package cn.mixu.test.Interface;

//接口可以多实现，而继承只能单继承
public class MyInterfaceImpl implements MyInterfaceA,MyInterfaceB {

    @Override
    public void methodA() {
        System.out.println("覆盖重写了A");
    }

    @Override
    public void methodB() {
        System.out.println("覆盖重写了B");
    }

    @Override
    public void method() {
        System.out.println("实现的两个接口的重名抽象方法只用重写一次");
    }

    @Override
    public void deMethod() {
        System.out.println("如果实现的两个接口的默认方法重名了那么实现类就必须重写默认方法");
    }


}
