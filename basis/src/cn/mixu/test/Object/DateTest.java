package cn.mixu.test.Object;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
   Date：
     构造方法：空参构造就是获取当前系统日期和时间
              传递long类型的毫秒值，可以把毫秒转化为Date日期
     getTime():把日期转化为毫秒值等效于System.currentTimeMillis()

   SimpleDateFormat：用于格式化和解析日期的具体类，参数传递指定的模式。如：yyyy年MM月dd日
     format：按照指定的模式，把Date日期格式化为符合模式的字符串
     parse：把符合模式的字符串，解析为Date日期。如果不符合模式则会抛出异常

*/

//计算出生到现在一共过了多少天
public class DateTest {
    public static void main(String[] args) throws ParseException {
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入出生日期，格式：yyyy-MM-dd");
        String next = sc.next();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //获取到写入的出生日期
        Date birthday = sdf.parse(next);
        //获取出生日期的毫秒值
        long birthdayTime = birthday.getTime();
        //获取当前日期的毫秒值
        long todayTime = new Date().getTime();
        long time=todayTime-birthdayTime;
        System.out.println("出生到现在一共过了"+time/1000/60/60/24+"天");
    }


}
