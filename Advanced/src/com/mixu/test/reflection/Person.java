package com.mixu.test.reflection;

public class Person {
    public String name;
    public int age;
    private String gender;

    public Person() {
    }

    private Person(String name){
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String show(String str){
        System.out.println("show："+str);
        return str;
    }

    public void eat(){
        System.out.println("吃");
    }
    public void eat(String food){
        System.out.println("吃"+food);
    }
}
