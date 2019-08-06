package com.neville.moduletest.myapplication.leetCode;


/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */

public class LeetCode91 {
    public static void main(String[] args) {
        int min = numDecodings("230");
        System.out.println(min);
    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                //单独合法
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                ///如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}



