package com.neville.moduletest.myapplication.leetCode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

public class LeetCode03 {
    public static void main(String[] args) {
        int max = lengthOfLongestSubstring("abba");
        System.out.println(max);
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char item = s.charAt(end);
            if (map.containsKey(item)) {
                int index = map.get(item);
                start = Math.max(start, index + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(item, end);
        }
        return max;
    }


}

