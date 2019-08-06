package com.neville.moduletest.myapplication.leetCode;


/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */

public class LeetCode62 {
    public static void main(String[] args) {
        int max = uniquePaths2(7, 3);
        System.out.println(max);
    }

    //回溯
    public static int uniquePaths(int m, int n) {
        int[][] temp = new int[m][n];
        return go(temp, m - 1, n - 1);
    }

    public static int go(int[][] temp, int cm, int cn) {
        if (temp[cm][cn] != 0) {
            return temp[cm][cn];
        }
        int count = 0;
        if (cm == 0 && cn == 0) {
            count++;
            return count;
        }
        if (cm > 0) {
            count += go(temp, cm - 1, cn);
        }
        if (cn > 0) {
            count += go(temp, cm, cn - 1);
        }
        temp[cm][cn] = count;
        return count;
    }

    //动态规划 dp[m][n]=dp[m-1][n]+dp[m][n-1]
    public static int uniquePaths2(int m, int n) {
        if (m - 1 == 0) {
            return 1;
        }
        if (n - 1 == 0) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (i - 1 == 0 ? 1 : dp[i - 1][j]) + (j - 1 == 0 ? 1 : dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];

    }

}

