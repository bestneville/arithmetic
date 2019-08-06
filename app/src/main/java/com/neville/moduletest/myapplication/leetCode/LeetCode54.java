package com.neville.moduletest.myapplication.leetCode;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

public class LeetCode54 {
    public static void main(String[] args) {
        int[] nums = {1};
        int max = maxSubArray(nums);
        System.out.println(max);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int tempMax = 0;
        for (int num : nums) {
            if (tempMax > 0) {
                tempMax += num;
            } else {
                tempMax = num;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }

}

