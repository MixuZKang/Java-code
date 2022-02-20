package cn.mixu.test.Interface;

public class interfaceTest {
    public static void main(String[] args) {
        //MyInterface m=new MyInterface();错误写法，不能直接实例化接口
        MyInterfaceImpl my=new MyInterfaceImpl();
        my.methodA();
        my.methodB();
        my.method();
        my.deMethod();
        //调用接口中的静态方法
        //my.stMethod();错误写法
        MyInterfaceA.stMethod();//直接通过接口调用，不能通过实现类
        //调用接口中的常量
        System.out.println(MyInterfaceA.NUM_MYID);
    }
}
