package cn.mixu.test.Object;

/*单例设计模式：
  1. 采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
  2. 如何实现：饿汉式  懒汉式
  3. 区分饿汉式和懒汉式
    饿汉式：一开始就创建好对象
        好处：是线程安全的
        坏处：导致对象加载时间过长
    懒汉式：需要的时候才创建对象
        好处：可以延迟对象的创建
        坏处：目前的写法是线程不安全，加了同步之后解决此问题
  4. 单例模式减少了系统性能的开销，如网站的计数器、数据库连接池、读取配置文件的类都可以设计为单例的
*/
public class SingletonTest {
    public static void main(String[] args) {
        Dog dog1 = Dog.getInstance();
        Dog dog2 = Dog.getInstance();
        System.out.println(dog1==dog2);//true
        Cat cat1 = Cat.getInstance();
        Cat cat2 = Cat.getInstance();
        System.out.println(cat1==cat2);//true
    }
}

//饿汉式
class Dog{

    //1.私有化构造方法
    private Dog(){ }
    //2.在内部创建当前类的对象，该对象也必须为静态
    private static Dog instance = new Dog();
    //3.提供公共的静态方法用来获取类的对象
    public static Dog getInstance(){
        return instance;
    }
}

//懒汉式
class Cat{

    //1.私有化构造方法
    private Cat(){ }
    //2.内部创建类的对象，该对象也必须为静态
    private static Cat instance = null;
    //3.提供公共的静态方法用来返回类的对象
    public static Cat getInstance(){
        //判断是否为空再创建对象，保证唯一性
        //方式一：效率较差
        /*synchronized (Cat.class) {
            if(instance==null){
                instance = new Cat();
            }
            return instance;
        }*/
        //方式二：判断如果对象已存在则不用再走同步，效率更高
        if (instance==null){
            synchronized (Cat.class) {
                if(instance==null){
                    instance = new Cat();
                }
            }
        }
        return instance;
    }
}
