package com.mixu.test.net.Socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
 * 创建一个服务器：
 *  实现客户端向服务器传递文件，服务器再把文件保存到自己的硬盘中：
 *  为了能区别服务器是在跟哪个客户端进行交互，服务器使用客户端自己的流来跟客户端进行交互
 *  比如客户端01请求服务器，服务器获取到客户端01的对象，并使用客户端01的流在跟它进行交互，同理客户端02请求过来也一样
 * */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器对象，传入指定的端口号，该端口号就代表服务器的端口号，客户端能够通过这个端口号访问到服务器
        ServerSocket server = new ServerSocket(8888);
        //使用死循环让服务器一直处于启动状态，来接收客户端的上传
        while (true) {
            //调用accept()方法阻塞，等待客户端连接，当有客户端连接后获取到请求的客户端对象
            Socket socket = server.accept();
            System.out.println("客户连接成功，客户信息为：" + socket.getRemoteSocketAddress());
            //使用线程提高程序效率，当有一个客户端请求上传文件，就开启一个线程并完成上传
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream is = null;
                    FileOutputStream fos = null;
                    try {
                        //获取客户端的网络字节输入流，使用客户端的流来读取数据
                        is = socket.getInputStream();
                        //判断E:\\study\\myshare文件夹是否存在，不存在则创建
                        File file = new File("E:\\study\\myshare\\upload");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        //自定义文件命名规则
                        String filename = "data" + System.currentTimeMillis() + new Random().nextInt(999999) + ".txt";
                        //服务器使用本地的字节输出流，把从客户端读取到的文件保存到硬盘上
                        fos = new FileOutputStream(file + "\\" + filename);
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        //读取客户端发来的文件
                        while ((len = is.read(bytes)) != -1) {
                            //把读取到的文件保存到服务器本地
                            fos.write(bytes, 0, len);
                        }
                        //获取客户端的网络字节输出流，使用客户端的流来给客户端回写数据
                        OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes());

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        //服务器需要一直启动所以不用关闭了
        //server.close();
    }


    //未优化过的简便版本
    public void test() throws IOException {
        //创建一个服务器对象
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            //获取到请求的客户端对象
            Socket socket = server.accept();
            //获取客户端的网络字节输入流
            InputStream is = socket.getInputStream();
            //判断文件夹是否存在，不存在则创建
            File file = new File("E:\\study\\myshare\\upload");
            if (!file.exists()) {
                file.mkdir();
            }
            String filename = "data" + System.currentTimeMillis() + new Random().nextInt(999999) + ".txt";
            //服务器使用本地的字节输出流，把从客户端读取到的文件保存到硬盘上
            FileOutputStream fos = new FileOutputStream(file + "\\" + filename);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                //把读取到的文件保存到服务器本地
                fos.write(bytes, 0, len);
            }
            //使用客户端的流来给客户端回写数据
            OutputStream os = socket.getOutputStream();
            os.write("上传成功".getBytes());
            fos.close();
            socket.close();
        }

    }
}
