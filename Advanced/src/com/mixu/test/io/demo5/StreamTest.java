package com.mixu.test.io.demo5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//在jdk1.8后集合中有个方法Stream，可以把集合转为Stream流
//Stream流属于管道流只能使用一次，使用完就不能再调用方法了
public class StreamTest {

    @Test
    public void show1() {
        //要求打印集合中姓张，名字三个字的人
        List<String> list = new ArrayList<>();
        list.add("张三三");
        list.add("李四");
        list.add("张无");
        /*
         * 使用传统的方法遍历集合太麻烦，我们只关注要打印的结果，并不关注打印的过程
         * Stream流中有个过滤方法filter，参数传递的是Predicate函数式接口
         * Predicate接口主要是用于判断
         * */
        list.stream().filter((String name) -> {
            //判断是否以“张”开头
            return name.startsWith("张");
        }).filter((String name) -> {
            //判断长度是否为3
            return name.length() == 3;
        }).forEach((String name) -> {
            //forEach方法里传递Consumer接口：给一个指定类型的数据
            //然后对数据进行消费(使用)，具体怎么使用需要我们自定义(输出，计算...)
            System.out.println(name);
        });
    }

    @Test
    public void show2() {
        String[] str={"张三","李四","王五"};
        //使用Stream流中的of方法可以把数组转换成Stream流
        Stream<String> stream = Stream.of(str);
        //使用forEach方法进行打印输出
        stream.forEach(name -> System.out.println(name));
    }

    @Test
    public void show3() {
        Stream<String> stream1 = Stream.of("1", "2", "3", "4", "5");
        //使用Stream里的map方法：里面传递Function接口，可以对数据进行映射
        Stream<Integer> stream2 = stream1.map((String n) -> {
            //把String类型的数据转换为Integer类型
            return Integer.parseInt(n);
        });
        stream2.forEach(i -> System.out.println(i));
    }

    @Test
    public void show4() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Stream<Integer> stream = list.stream();
        //count方法用于返回Stream流中元素的个数
        long count = stream.count();
        System.out.println(count);
    }

    @Test
    public void show5() {
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六");
        //使用limit方法对Stream流中的元素进行截取,返回索引为3之前的所有元素
        Stream<String> limit = stream.limit(3);
        limit.forEach(n -> System.out.println(n));
    }

    @Test
    public void show6() {
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六");
        //使用skip方法跳过前两个元素，返回包括索引为2之后的所有元素
        Stream<String> skip = stream.skip(2);
        skip.forEach(n -> System.out.println(n));
    }

    @Test
    public void show7() {
        Stream<String> stream1 = Stream.of("张三", "李四", "王五", "赵六");
        Stream<String> stream2 = Stream.of("1", "2", "3", "4");
        //使用concat方法合并流
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(n -> System.out.println(n));
    }
}
