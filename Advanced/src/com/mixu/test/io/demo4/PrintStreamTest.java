package com.mixu.test.io.demo4;

import java.io.PrintStream;

/*
* 打印流：
* 只负责数据的输出，不负责读取
* 继承OutputStream字节输出流
* 如果使用父类的write方法写数据，那么会查看编码表写 97->a
* 如果使用自己的特有方法print/println方法写数据，则原样输出 97->97
* */
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        PrintStream ps=new PrintStream("E:\\study\\myshare\\print.txt");
        ps.write(97);//a
        ps.println(97);//97
        ps.println('a');
        ps.println("你好");
        ps.println(true);
        //把输出语句的目的地改变为打印流的目的地(print.txt文件中)
        System.setOut(ps);
        System.out.println("在打印流中输出");
        ps.close();
    }
}
