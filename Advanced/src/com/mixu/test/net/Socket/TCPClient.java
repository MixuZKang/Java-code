package com.mixu.test.net.Socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * Socket：它的诞生是为了应用程序能够更方便的将数据经由传输层（TCP/IP所在的层）来传输，
 *  所以它本质上就是对 TCP/IP的运用进行了一层封装，然后应用程序直接调用 Socket API即可进行通信。
 * Socket是如何工作的？
 *  分为两部分，服务端需要建立 Socket来监听指定的地址，然后等待客户端来连接。
 *  而客户端则需要建立 Socket并与服务端的 Socket地址进行连接。
 *  TCP/IP在连接过程中需要经历“三次握手”来确定连接是否稳定，确定连接正常后即可进行数据的发送与接收，
 *  连接使用完之后需要关闭，TCP/IP连接关闭过程中需要经历“四次挥手”。
 *
 * 创建一个客户端：
 *  实现客户端向服务器传递文件，服务器再把文件保存到自己的硬盘中：
 *  客户端与服务器进行交互必须使用Socket提供的网络流
 *  当创建客户端对象Socket的时候就会去请求服务器，如果服务器没启动就会抛出 ConnectException 连接异常（服务器要先于客户端启动）
 *
 * 客户端连接到服务端的过程中，已知服务端的端口是固定的 8888，而客户端我们并没有给它手动指定端口，
 * 但实际上客户端也是通过一个端口跟服务端进行通讯的，这个端口是由TCP/IP分配的一个随机的，不确定的端口；
 * */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //客户端使用本地的字节输入流读取本地文件
        FileInputStream fis = new FileInputStream("E:\\study\\myshare\\a.txt");
        //创建一个客户端对象Socket，传入服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //获取网络字节输出流
        OutputStream os = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        //读取本地文件
        while ((len = fis.read(bytes)) != -1) {
            //使用网络字节输出流向服务器发送文件
            os.write(bytes, 0, len);
        }
        //**把网络字节输出流结束掉，避免发生阻塞**
        socket.shutdownOutput();
        //获取网络字节输入流
        InputStream is = socket.getInputStream();
        //使用网络字节输入流读取服务器回写的数据
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
        socket.close();
    }
}
