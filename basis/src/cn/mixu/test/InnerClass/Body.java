package cn.mixu.test.InnerClass;

public class Body {
    int num = 10;

    public void method() {
        System.out.println("外部类方法被调用了");
        //调用内部类Heart里的方法beat()
        new Heart().beat();
    }
    //成员内部类
    public class Heart {
        int num = 20;

        public void beat() {
            int num = 30;
            System.out.println("心脏跳动(内部类)");
            System.out.println(num);//30
            System.out.println(this.num);//20
            System.out.println(Body.this.num);//10
        }
    }

    //定义一个方法，方法里面定义局部内部类
    public void methodOuter(){
        int num=10;
        //局部内部类
        class Inner{
            public void methodInner(){
                System.out.println("局部内部类被调用了");
                //局部内部类如果希望访问所在方法的局部变量，那么这个局部变量必须是不变的(有效final)
                //从java8开始，不加final也可以，但是必须保证局部变量事实不变
                System.out.println(num);
            }
        }

        Inner in = new Inner();
        in.methodInner();
    }


}
