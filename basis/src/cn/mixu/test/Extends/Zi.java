package cn.mixu.test.Extends;

public class Zi extends Fu {
    public Zi() {
        //如果什么都不写，则默认有一个super调用父类无参构造方法
        super(10);//手动调用父类有参构造方法
        System.out.println("子类构造方法");
    }

    int num = 200;

    public void method() {
        int num = 100;
        System.out.println("局部变量："+num);//输出局部变量
        System.out.println("成员变量："+this.num);//输出成员变量
        System.out.println("父类成员变量："+super.num);//输出父类成员变量
    }

    /* 重写(Override)
    1、子类的方法重写了父类的方法，那么子类中该方法的访问级别不允许低于父类的访问级别。
        如果父类为protected那么子类必须是protected或public，不能是private
        这是为了确保可以使用父类实例的地方都可以使用子类实例，也就是确保满足里氏替换原则。

    2、子类方法的返回类型必须是父类方法返回类型或为其子类型。
    */
    public void show(){
        //如果子类重写了父类的中某个方法，可以通过使用super来引用父类的方法实现。
        super.show();
        System.out.println("子类重新父类show()方法");
    }


}
