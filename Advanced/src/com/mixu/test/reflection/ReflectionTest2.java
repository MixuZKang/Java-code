package com.mixu.test.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest2 {

    /*在Person中要求提供一个public的空参构造器，其原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承该运行时类，默认调用super()时，保证父类有空参构造器
    */
    @Test
    public void test01() throws Exception {
        //加载字节码文件
        Class aClass = Class.forName("cn.mixu.test.reflection.Person");
        //调用newInstance()方法创建运行时类的对象，内部调用了运行时类的空参构造
        Person p1 = (Person) aClass.newInstance();
    }


    /*Class对象功能：
	  获取：
		1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取指定名称的 public修饰的成员变量
			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)  获取指定名称的成员变量，不考虑修饰符

        * Field：成员变量
        * 操作：
            1. 设置值
                * void set(Object obj, Object value)
            2. 获取值
                * get(Object obj)
        忽略访问权限修饰符的安全检查
            * setAccessible(true):暴力反射，开启后还能略微提升反射的性能
    */
    @Test
    public void test02() throws Exception {
        //加载字节码文件
        Class aClass = Class.forName("cn.mixu.test.reflection.Person");
        //创建运行时类的对象
        Person person = (Person) aClass.newInstance();
        //获取所有public修饰的成员变量，返回一个Field数组
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
            //获取成员变量的权限修饰符，返回int类型：默认修饰符是0 public是1 private是2 protected是4 static是8 final是16
            //可以使用Modifier.toString(modifiers)把int类型的表示形式改为字符串类型
            int modifiers = field.getModifiers();
            System.out.println("该成员变量的权限修饰符：" + Modifier.toString(modifiers));
            //获取成员变量的数据类型
            Class type = field.getType();
            System.out.println("该成员变量的数据类型：" + type);
            //获取成员变量的变量名
            String name = field.getName();
            System.out.println("该成员变量的变量名：" + name);
        }
        //获取指定名称的 public修饰的成员变量
        Field fieldAge = aClass.getField("age");
        System.out.println(fieldAge);
        //设置当前属性的值，参数传入指定对象和需要设置的值
        fieldAge.set(person, 28);
        //获取指定对象的属性值
        Object p_age = fieldAge.get(person);
        System.out.println("person对象的age为：" + p_age);
    }


    /*Class对象功能：
	  获取：
        2. 获取构造方法们
                * Constructor<?>[] getConstructors()
                * Constructor<T> getConstructor(类<?>... parameterTypes)
                * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
                * Constructor<?>[] getDeclaredConstructors()

        * Constructor:构造方法
        * 创建对象：
            * T newInstance(Object... initargs)
            * 如果想要使用空参数构造方法创建对象，可以使用Class对象的newInstance方法
      获取父类：getSuperclass()
      获取带泛型的父类：getGenericSuperclass()

      * 获取运行时类带泛型的父类，并获取其泛型：属于功能性代码，会用就行
            获取带泛型的父类:
            Type gsClass = aClass.getGenericSuperclass();
            ParameterizedType paramType = (ParameterizedType) gsClass;
            获取泛型的类型:
            Type[] actualTypeArguments = paramType.getActualTypeArguments();
            System.out.println(((Class)actualTypeArguments[0]).getName());
    */
    @Test
    public void test03() throws Exception {
        //加载字节码文件
        Class aClass = Class.forName("cn.mixu.test.reflection.Person");
        //不考虑权限修饰符获取指定的构造方法，参数传递该构造方法的参数类型
        Constructor constructor = aClass.getDeclaredConstructor(String.class);
        System.out.println(constructor);
        //使用暴力反射，忽略修饰符的安全检查
        constructor.setAccessible(true);
        //使用私有的有参构造方法创建对象
        Person p1 = (Person) constructor.newInstance("张三");
        System.out.println(p1);

    }

    /*Class对象功能：
	  获取：
        3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)
			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)

	    * Method：方法对象
        * 执行方法：
            * Object invoke(Object obj, Object... args)
              该方法的返回值即为对应类中调用的方法的返回值，如果被调用的方法没有返回值则返回null
        * 获取方法名称：
            * String getName:获取方法名
    */
    @Test
    public void test04() throws Exception {
        //加载字节码文件
        Class aClass = Class.forName("cn.mixu.test.reflection.Person");
        //创建运行时类的对象
        Person person = (Person) aClass.newInstance();
        //获取全类名
        String name = aClass.getName();
        System.out.println(name);
        //获取所有成员方法，不考虑修饰符
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
            //获取方法的权限修饰符
            System.out.println("该方法的权限修饰符：" + Modifier.toString(method.getModifiers()));
            //获取方法的返回值类型
            System.out.println("该方法的返回值类型：" + method.getReturnType());

        }
        //获取指定的成员方法，参数传递要获取的方法的名称和该方法的形参列表
        Method show = aClass.getDeclaredMethod("show", String.class);
        //调用方法，参数传递方法的调用者(对象)和方法的实参
        Object str = show.invoke(person, "张三");////对比 String str = person.show("张三")
        System.out.println("show方法的返回值为：" + str);

    }

}
