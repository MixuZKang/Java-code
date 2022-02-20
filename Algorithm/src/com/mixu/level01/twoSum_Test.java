package com.mixu.level01;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组nums和一个整数目标值target，在该数组中找出“和”为目标值target的那两个整数，并返回它们的数组下标
public class twoSum_Test {

    @Test
    public void test(){
        int[] arr = {7, 11, 15, 2, 10, 4, 6};
        int target = 22;
        int[] twoSum = twoSum(arr, target);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }
    }

    // 22-7=15 不存在 --> 22-11=11 不存在 --> 22-15=7 存在，获取7的索引赋给arr[0]，并把当前数值15的索引i赋给arr[1]
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果Map中存在值为 目标值target - nums[i] 的key
            if (map.containsKey(target - nums[i])) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
                return arr;
            }
            //不存在则添加当前 nums[i]值为key，value为索引
            map.put(nums[i], i);
        }
        return arr;
    }
}
