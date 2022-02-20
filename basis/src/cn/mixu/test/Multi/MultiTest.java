package cn.mixu.test.Multi;

/*
多态性：父类引用指向子类对象（对象的向上转型）
    就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，
    而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，
    必须在由程序运行期间才能决定。因为在程序运行时才确定具体的类，这样不用修改源程序代码，
    就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的具体方法随之改变，
    即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。
格式：
    父类名 对象名 = new 子类名();
    接口名 对象名 = new 实现类名();

* 多态访问成员变量的方式跟普通的继承没有区别
* 多态成员方法的访问规则：编译看左边，运行看右边
*/

public class MultiTest {
    public static void main(String[] args) {
        Fu obj = new Zi();
        obj.methodFu();
        //obj.methodZi();错误写法，编译看左边，左边父类中找不到methodZi()方法
        //使用向下转型，把父类引用转为子类引用，进行“还原”就可以使用子类的特有方法
        Zi zi = (Zi) obj;
        zi.methodZi();
        //另一种写法 ((Zi) obj).methodZi();
        System.out.println("=============");
        //等号左边是谁就用谁的成员变量，没有则向上找
        System.out.println(obj.num);//等号左边是Fu所以输出10
        //该方法属于谁就用谁，没有则向上找
        obj.showNum();//子类没重写：输出Fu的10   子类重写了：输出Zi的20
        System.out.println("=============");
        //方法参数传递父类，所以这里可以new一个子类，也就是多态
        giveMe(new Sun());
    }

    public static void giveMe(Fu obj){
        //如果传递的是一个Zi类则调用其特有方法
        if(obj instanceof Zi){
//            Zi zi = (Zi) obj;
//            zi.methodZi();
            ((Zi) obj).methodZi();
        }
        //如果传递的是一个Sun类则调用其特有方法
        if(obj instanceof Sun){
//            Sun s1 = (Sun) obj;
//            s1.methodSun();
            ((Sun) obj).methodSun();
        }
    }

}
