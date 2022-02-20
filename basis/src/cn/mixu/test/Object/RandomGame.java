package cn.mixu.test.Object;

import java.util.Random;
import java.util.Scanner;

//猜数字
public class RandomGame {
    public static void main(String[] args) {
        Random random = new Random();
        //random生成随机数从0开始
        int num = random.nextInt(20) + 1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.println("这是第" + i + "次猜，请输入数字：");
            int input = scanner.nextInt();
            if (input > num) {
                System.out.println("太大了");
            } else if (input < num) {
                System.out.println("太小了");
            } else {
                System.out.println("猜中了");
                return;
            }
        }
        System.out.println("没猜对");
    }
}
