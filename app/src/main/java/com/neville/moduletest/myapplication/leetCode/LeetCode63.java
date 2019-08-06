package com.neville.moduletest.myapplication.leetCode;


/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */

public class LeetCode63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int max = uniquePaths(obstacleGrid);
        System.out.println(max);
    }


    //动态规划 dp[m][n]=dp[m-1][n]+dp[m][n-1]
    public static int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;//行长度
        int n = obstacleGrid[0].length;//列长度。
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]) + (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];

    }

}

