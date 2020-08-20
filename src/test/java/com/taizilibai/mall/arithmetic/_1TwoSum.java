package com.taizilibai.mall.arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1、两数之和
 * @Author: zxx
 * @Date: 2020/8/20 10:01
 */
public class _1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];

        for(int i=0; i<nums.length; i++) {
            for(int j=nums.length-1; j>i; j--) {
                if(nums[i] + nums[j] > target){
                    continue;
                }
                if(nums[i] + nums[j] < target) {
                    break;
                }
                if(nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8};
        int[] ints = twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}
