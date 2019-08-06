package com.neville.moduletest.myapplication.leetCode;


import java.util.HashMap;

public class LeetCode13 {
    public static void main(String[] args) {
        int roman = romanToInt2("MCMXCIV");
        System.out.println(roman);
    }

    //还有一种方法，倒序遍历，减法
    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int index = 0;
        int result = 0;
        while (index < s.length()) {
            if (index < s.length() - 1 && map.containsKey(s.substring(index, index + 2))) {
                result += map.get(s.substring(index, index + 2));
                index += 2;
            } else {
                result += map.get(s.substring(index, index + 1));
                index++;
            }
        }
        return result;

    }

    public static int romanToInt2(String s) {
        s = s.replace("IV", "Y");
        s = s.replace("IX", "T");
        s = s.replace("XL", "U");
        s = s.replace("XC", "R");
        s = s.replace("CD", "O");
        s = s.replace("CM", "W");
        HashMap<String, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    sum += 1000;
                    break;
                case 'W':
                    sum += 900;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'O':
                    sum += 400;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'R':
                    sum += 90;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'U':
                    sum += 40;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'T':
                    sum += 9;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'Y':
                    sum += 4;
                    break;
                case 'I':
                    sum += 1;
                    break;
            }
        }
        return sum;


    }


}

