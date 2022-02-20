package com.mixu.test.io.demo4;

import java.io.Serializable;

//要进行序列化和反序列化的类必须实现Serializable接口
public class Person implements Serializable {
    //由于每次修改这个类，序列号都会发生改变，从而导致反序列化异常
    //所以我们自己定义一个永远不会发生改变的序列号
    private static final long serialVersionUID=42L;
    private String name;
    //加入transient瞬态关键字修饰的成员不会被序列化
    private /*transient*/ int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
