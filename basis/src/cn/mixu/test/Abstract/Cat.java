package cn.mixu.test.Abstract;

//继承抽象类
public class Cat extends Animal {
    //重写父类里的抽象方法
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
    @Override
    public void sleep() {
        System.out.println("睡觉");
    }
}
