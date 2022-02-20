package com.mixu.test.net;

import java.net.InetAddress;
import java.net.UnknownHostException;


/*
    netstat -an指令：可以在cmd命令行窗口查看当前主机网络情况，包括端口监听的情况和网络连接的情况
    netstat -an | more 可以分页显示
*/
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的 InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);// DESKTOP-CMBO8AS/192.168.1.2

        //根据指定主机名，获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-CMBO8AS");
        System.out.println(host1);

        //根据指定域名返回 InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //通过 InetAddress对象获取对应的IP地址
        String address = host2.getHostAddress();
        System.out.println("host2对于的IP地址：" + address);

        //通过 InetAddress对象获取对应的主机名
        String hostName = host2.getHostName();
        System.out.println("host2对于的主机名：" + hostName);
    }
}
