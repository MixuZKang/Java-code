package com.mixu.test.throwable;

import java.util.Scanner;

//模拟注册操作，如果用户名存在则抛出异常
public class RegisterExceptionTest {
    //用字符串数组保存已经注册的用户(伪数据库)
    static String[] userNames={"张三","李四","王五"};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = sc.next();
        checkUsername(userName);
    }
    public static void checkUsername(String userName){
        //遍历伪数据库，判断输入的用户名是否跟数据库里的数据相同
        for (String s : userNames) {
            if(s.equals(userName)){
                try {
                    throw new RegisterException("给用户已被注册");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        System.out.println("注册成功");
    }
}
