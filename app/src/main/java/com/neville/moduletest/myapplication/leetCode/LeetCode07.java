package com.neville.moduletest.myapplication.leetCode;


/**
 * 倒置数字
 */

public class LeetCode07 {
    public static void main(String[] args) {
        int resulterse = resulterse(200);
        System.out.println(resulterse);
    }

    public static int resulterse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
                return 0;
            result = result * 10 + pop;
        }
        return result;
    }


}

