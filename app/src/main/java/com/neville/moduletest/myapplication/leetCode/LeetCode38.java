package com.neville.moduletest.myapplication.leetCode;


import java.util.HashMap;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

public class LeetCode38 {

    public static void main(String[] args) {
        String result = countAndSay(4);
        System.out.println(result);
        HashMap<String,String>map=new HashMap<>();
    }

    public static String countAndSay(int n) {
        if (n < 1 || n > 30) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String ss = countAndSay(n - 1);
        int count = 1;
        String result = "";
        char item = ss.charAt(0);
        for (int i = 1; i <= ss.length(); i++) {
            if (i == ss.length()) {
                result = result + count + item;
            } else {
                if (ss.charAt(i) == ss.charAt(i - 1)) {
                    count++;
                } else {
                    result = result + count + item;
                    item = ss.charAt(i);
                    count = 1;
                }
            }

        }
        return result;
    }

}

