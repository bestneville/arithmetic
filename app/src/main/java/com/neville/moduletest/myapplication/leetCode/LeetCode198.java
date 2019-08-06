package com.neville.moduletest.myapplication.leetCode;


/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */

public class LeetCode198 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int max = rob3(nums);
        System.out.println(max);
    }

    //奇偶法
    public static int rob(int[] nums) {
        int oddNumber = 0;//奇数
        int evenNumber = 0;//偶数
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenNumber += nums[i];
                evenNumber = Math.max(oddNumber, evenNumber);
            } else {
                oddNumber += nums[i];
                oddNumber = Math.max(oddNumber, evenNumber);
            }
        }
        return Math.max(oddNumber, evenNumber);
    }


    //递归法
    public static int rob2(int[] nums) {

        return robRecursion(nums, nums.length - 1);
    }

    public static int robRecursion(int[] nums, int lastIndex) {
        if (lastIndex == 0) {
            return nums[0];
        }
        if (lastIndex == -1) {
            return 0;
        }
        int sum1 = robRecursion(nums, lastIndex - 2) + nums[lastIndex];
        int sum2 = robRecursion(nums, lastIndex - 1);
        return Math.max(sum1, sum2);
    }

    //动态规划
    public static int rob3(int[] nums) {
        int preMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(preMax + nums[i], currMax);
            preMax = temp;
        }
        return currMax;
    }

}

