package com.neville.moduletest.myapplication.leetCode;


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class LeetCode70 {
    public static void main(String[] args) {
        int step = climbStairs2(3);
        System.out.println(step);

    }


    public static int climbStairs(int n) {
        int[] temp = new int[n + 1];
        int step = climbStairs(n, temp);
        return step;
    }

    //记忆递归法
    public static int climbStairs(int n, int[] temp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (temp[n] > 0) {
            return temp[n];
        }
        temp[n] = climbStairs(n - 1, temp) + climbStairs(n - 2, temp);
        return temp[n];
    }


    //动态规划
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];

    }

}

