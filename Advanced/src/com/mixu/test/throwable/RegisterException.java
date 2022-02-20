package com.mixu.test.throwable;



//自定义异常：可以通过继承 Exception 类或其任何子类来实现自己的自定义异常类
//自定义异常类可以有自己的变量和方法来传递错误代码或其它异常相关信息来处理异常
public class RegisterException extends Exception{

    public RegisterException() {

    }

    public RegisterException(String message) {
        super(message);
    }
}
