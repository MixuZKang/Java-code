package com.mixu.test.throwable;

import java.nio.file.FileAlreadyExistsException;
import java.util.Objects;

public class throwTest {

    /*异常：导致程序的正常流程被中断的事件，叫做异常；只要在Java语句执行中产生异常则一个异常对象就会被创建
    Throwable是所有异常的父类，它有两个直接子类Error和Exception
        Error：表示系统级的错误，是java运行环境内部错误或者硬件问题，不能指望程序来处理这样的问题
            除了退出运行外别无选择，它是java虚拟机抛出的
        Exception：表示程序需要捕捉、需要处理的异常，是由与程序设计的不完善而出现的问题，程序可以处理的问题。
            被检查的异常（Checked exception）：
                又称为编译期异常，在程序中能预期且要尝试修复，如我们必须捕获FileNotFoundException异常并为用户提供有用信息和合适日志来进行调试
                Exception是所有被检查的异常的父类
            运行时的异常（runtime exception）：
                又称为不受检查异常，譬如我们检索数组元素之前必须确认数组的长度，否则就可能会抛出ArrayIndexOutOfBoundException运行时异常
                RuntimeException是所有运行时异常的父类。

    * throw 跟 throws有什么区别：
    使用位置：
        throw：使用的位置在方法中，后面跟的异常对象实例，表示抛出异常，由方法体内的语句处理
            1、throw是具体向外抛出异常的动作，所以它抛出的是一个异常实例，执行throw一定是抛出了某种异常。
            2、如果方法中有throw抛出RuntimeException及其子类则声明上可以没有throws
            如果方法中有throw抛出Exception及其子类则声明上必须有throws
        throws：作用在方法声明后面，表示如果抛出异常，由该方法的调用者来进行异常的处理
            1、throws主要是声明这个方法会抛出某种类型的异常，让它的使用者要知道需要捕获的异常的类型。
            它表示出现异常的一种可能性，并不一定会发生这种异常。
            2、如果后面跟的是RuntimeException及其子类则该方法可以不用处理
            如果后面跟的是Exception及其子类则必须要编写代码进行try/catch处理或者调用的时候抛出

    * 被检查的异常和运行时的异常有什么区别：
        被检查的异常应该用try-catch块代码处理或用throws关键字抛出，运行时的异常在程序中不要求被处理或用throws抛出
        Exception是所有被检查异常的基类，而RuntimeException(是Exception的子类)是所有运行时异常的基类
        被检查的异常适用于那些不是因程序引起的错误情况（如FileNotFoundException）
        而运行时的异常通常都是由于糟糕的编程引起（如NullPointerException

    * 如果执行finally代码块之前方法返回了结果或者JVM退出了，这时finally块中的代码还会执行吗？
        只有在try里面通过System.exit(0)来退出JVM的情况下finally块中的代码才不会执行，其他return返回等情况都会正常调用

    * 如果catch捕获多个异常则要保证子类靠前父类靠后的原则，如Exception要放在RuntimeException下面

    * 重写方法抛出的异常不能是原方法抛出异常的父类，如原方法在父类中抛出IOException
      子类重写该方法抛出的异常只能是IOException或是其子类，但不能是其父类

    * 如果方法没有抛出受检查类型异常(如IOException)则在调用方法的地方就不能主动添加受检查类型异常捕获try/catch
      但是可以添加运行时异常(RuntimeException)或者Exception捕获，因为Exception可以用来捕捉所有运行时异常

    * jdk7以后可以在catch中声明多个异常，就像原来用多个catch块一样，减少处理异常时的代码量

    * final和finally是Java的关键字，而finalize()则是方法，是垃圾回收器在回收一个对象前调用的
    */
    public static void main(String[] args) throws Exception {
        int[] arr1=null;
//        int e1 = getElement(arr1,0);
        int[] arr2={1,2,3,4};
        int e2 = getElement(arr2, 8);
//        System.out.println(e1);
        System.out.println(e2);
        System.out.println("==================");
        readFile("c:\\a.txt");
    }

    public static int getElement(int[] a,int index){
        //运行期异常不用处理
        Objects.requireNonNull(a,"数组的值为null");
        if(index<0||index>a.length-1){
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        int i = a[index];
        return i;
    }


    public static void readFile(String fileName) throws FileAlreadyExistsException {
        //编译异常必须要处理，要么throws声明，要么try/catch捕获
        if(!fileName.equals("c:\\a.txt")){
            throw new FileAlreadyExistsException("传递的文件路径不是c:\\a.txt");
        }
        System.out.println("路径正确");
    }


}
