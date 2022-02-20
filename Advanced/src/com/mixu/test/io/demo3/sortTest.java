package com.mixu.test.io.demo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Set;

//对文本进行排序
public class sortTest {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("E:\\study\\myshare\\sort.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\study\\myshare\\aftersort.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            //对读取到的文本进行切割(获取“.”前后的文本，返回到arr数组里面)，获取行中序号和文本的内容
            String[] arr = line.split("\\.");
            //把切割好的序号和文本添加到map集合中
            map.put(arr[0], arr[1]);
        }
        //调用keySet方法把key存储到set集合中
        Set<String> in = map.keySet();
        //遍历set集合
        for (String key : in) {
            //通过key获取value
            String value = map.get(key);
            //把每一个键值对拼接为一个文本行
            line = key + "." + value;
            //把拼接好的文本写入到文件中
            bw.write(line);
            //换行
            bw.newLine();
        }
        //关闭流
        bw.close();
        br.close();
    }
}
