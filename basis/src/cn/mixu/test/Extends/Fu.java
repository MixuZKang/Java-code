package cn.mixu.test.Extends;

public class Fu {
    int num = 300;

    public Fu() {
        System.out.println("父类无参构造方法");
    }

    public Fu(int num) {
        System.out.println("父类有参构造方法");
    }

    //protected表示仅子类可见
    protected void show(){
        System.out.println("父类show()方法");
    }



}
