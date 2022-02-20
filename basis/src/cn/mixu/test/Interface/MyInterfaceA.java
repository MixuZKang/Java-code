package cn.mixu.test.Interface;

public interface MyInterfaceA {
    //接口的成员(属性 + 方法)默认都是 public 的，并且不允许定义为 private 或者 protected
    //接口的属性默认都是 static 和 final 的
    public static final int NUM_MYID = 10;

    public void methodA();

    void method();

    default void deMethod() {
        System.out.println("这是一个接口的默认方法,默认方法也可以被实现类重写");
    }

    static void stMethod(){
        System.out.println("这是一个静态方法,不能通过接口实现类来调用");
    }

}
