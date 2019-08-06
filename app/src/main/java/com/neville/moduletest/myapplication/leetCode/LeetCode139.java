package com.neville.moduletest.myapplication.leetCode;


import com.neville.moduletest.myapplication.utils.MyUtils;

import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 */

public class LeetCode139 {
    public static void main(String[] args) {
        List<String> wordDict = MyUtils.newList("leet", "code");
        boolean max = wordBreak("leetcode", wordDict);
        System.out.println(max);
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        return inDict(0, s, new Boolean[s.length()], wordDict);
    }

    //记忆化回溯
    public static boolean inDict(int start, String s, Boolean[] memo, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && inDict(end, s, memo, wordDict)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


    //动态规划
    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

