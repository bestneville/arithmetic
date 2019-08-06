package com.neville.moduletest.myapplication.leetCode;


/**
 * 倒置数字
 */

public class LeetCode14 {
    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }

    //也可以使用分治，二分等方法
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = "";
        int index = 0;
        boolean flag = true;
        while (flag) {
            if (strs[0].length() > index) {
                char firstChar = strs[0].charAt(index);
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() <= index || strs[i].charAt(index) != firstChar) {
                        flag = false;
                    }
                }
                if (flag) {
                    s += firstChar;
                    index++;
                }
            } else {
                flag = false;
            }

        }
        return s;
    }


}

