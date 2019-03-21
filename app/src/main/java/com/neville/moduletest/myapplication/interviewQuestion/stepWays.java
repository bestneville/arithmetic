package com.neville.moduletest.myapplication.interviewQuestion;

/**
 * 台阶算法，假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个， n 个台阶有多少种走法
 */

public class stepWays {
    public static void main(String[] args) {
        int step = step(10);
        System.out.print(step);
    }

    private static int step(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return step(n - 1) + step(n - 2);
    }
}
