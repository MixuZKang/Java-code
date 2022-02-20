package cn.mixu.test.InnerClass;

//匿名内部类
public class InnerClassTest02 {
    /*
     * 如果接口的实现类或者父类的子类只需要使用唯一一次
     * 那么这种情况可以省略掉实现类或者子类的定义，改为
     * 使用匿名内部类：
     * 接口名 对象名 = new 接口名(){ 重写所有抽象方法 };
     * */
    public static void main(String[] args) {
        MyInterface obj = new MyInterface() {
            @Override
            public void methodIn() {
                System.out.println("AAA");
            }
        };
        obj.methodIn();

        //使用匿名对象调用匿名内部类
        new MyInterface() {
            @Override
            public void methodIn() {
                System.out.println("BBB");
            }
        }.methodIn();

        //在方法里面使用匿名内部类
        //因为方法print参数传递的是一个接口所以可以使用匿名内部类
        print(new MyInterface() {
            @Override
            public void methodIn() {
                System.out.println("CCC");
            }
        });
    }

    public static void print(MyInterface m) {
        m.methodIn();
    }
}
