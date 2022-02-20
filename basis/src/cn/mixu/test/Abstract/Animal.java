package cn.mixu.test.Abstract;

//抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类。
public abstract class Animal {
    //定义两个抽象方法
    public abstract void eat();
    public abstract void sleep();

    //抽象类中可以有普通方法
    public void show(){

    }
}
