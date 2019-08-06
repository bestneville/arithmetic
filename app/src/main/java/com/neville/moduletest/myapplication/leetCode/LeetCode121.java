package com.neville.moduletest.myapplication.leetCode;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

public class LeetCode121 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int max = maxProfit2(nums);
        System.out.println(max);
    }

    //暴力法
    public static int maxProfit(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                max=Math.max(max,prices[i]-prices[j]);
            }
        }
        return max;
    }


    //动态规划
    public static int maxProfit2(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min=prices[i];
            }else if(prices[i]-min>max){
                max=prices[i]-min;
            }
        }
        return max;
    }
}

