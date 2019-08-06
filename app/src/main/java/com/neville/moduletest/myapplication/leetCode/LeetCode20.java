package com.neville.moduletest.myapplication.leetCode;


import java.util.Stack;

/**
 * 有效的括号
 */

public class LeetCode20 {
    public static void main(String[] args) {
        boolean isValid = isValid("{[]}");
        System.out.println(isValid);
    }

    //一开始使用 map put (  )的方式，少很多判断
    public static boolean isValid(String s) {
        if (s == null) return false;
        if ("".equals(s)) return true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            switch (item) {
                case '(':
                    stack.add(')');
                    break;
                case '[':
                    stack.add(']');
                    break;
                case '{':
                    stack.add('}');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != ')') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != ']') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '}') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();

    }

}

