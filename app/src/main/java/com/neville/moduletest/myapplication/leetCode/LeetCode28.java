package com.neville.moduletest.myapplication.leetCode;


/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */

public class LeetCode28 {
    public static void main(String[] args) {
        int len = strStr("a", "a");
        System.out.println(len);
    }

    //暴力搜索，可以使用BM或者KMP匹配
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        int index = 0;
        int len = needle.length();
        while (index < haystack.length() - len + 1) {
            String item = haystack.substring(index, index + len);
            if (item.equals(needle)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

}

