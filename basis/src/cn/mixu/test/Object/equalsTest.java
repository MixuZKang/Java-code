package cn.mixu.test.Object;


//自定义类型如何重写equals()方法
public class equalsTest {
    public static void main(String[] args) {
        Person p1 = new Person("tom", 18);
        Person p2 = new Person("tom", 18);
        //如果没有重写equals()，则调用的是Object的equals()方法，默认比较的是地址值
        System.out.println(p1.equals(p2));
    }
}

class Person {
    private String name;
    private int age;

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
    public boolean equals(Object obj) {
        //如果传递的对象与当前对象是同一个，直接返回true
        if (this == obj) {
            return true;
        }
        //判断传递来的对象的运行类型是否为Person类型
        if (obj instanceof Person) {
            //把obj向下转型为Person，为了能取出Person中的属性
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }
}
