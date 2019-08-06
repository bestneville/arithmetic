package com.neville.moduletest.myapplication.leetCode;


/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */

public class LeetCode64 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int min = minPathSum2(obstacleGrid);
        System.out.println(min);
    }

    public static int minPathSum(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        return min(temp, grid[0][0], grid, 0, 0);
    }

    public static int min(int[][] temp, int sum, int[][] grid, int m, int n) {
        if (temp[m][n] != 0) {
            System.out.println("m=" + m + "n=" + n);
            return temp[m][n];
        }

        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            return sum;
        }
        if (m < grid.length - 1) {
            //往下
            num1 = min(temp, sum + grid[m + 1][n], grid, m + 1, n);
        }
        if (n < grid[0].length - 1) {
            //往右
            num2 = min(temp, sum + grid[m][n + 1], grid, m, n + 1);
        }
        int min = Math.min(num1, num2);
        if (m != 0 && n != 0 && m != grid.length - 1 && n != grid.length - 1) {
            temp[m][n] = min;
        }
        return min;

    }


    public static int minPathSum2(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


}

