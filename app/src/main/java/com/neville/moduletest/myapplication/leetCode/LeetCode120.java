package com.neville.moduletest.myapplication.leetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */

public class LeetCode120 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(-2);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(-5);
        list3.add(-5);
        list3.add(9);
        List<Integer> list4 = new ArrayList<>();
        list4.add(-4);
        list4.add(-5);
        list4.add(4);
        list4.add(4);
        arr.add(list1);
        arr.add(list2);
        arr.add(list3);
        arr.add(list4);
        int min = minimumTotal2(arr);
        System.out.println(min);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        if (triangle.size() >= 2) {
            dp[0] = triangle.get(0).get(0) + triangle.get(1).get(0);
            dp[1] = triangle.get(0).get(0) + triangle.get(1).get(1);
        } else {
            return triangle.get(0).get(0);
        }
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> child = triangle.get(i);
            int tempStart = child.get(0);
            int tempDpEnd = dp[child.size() - 2] + child.get(child.size() - 1);
            for (int j = child.size() - 2; j > 0; j--) {
                dp[j] = Math.min(child.get(j) + dp[j], child.get(j) + dp[j - 1]);
            }
            dp[0] += tempStart;
            dp[child.size() - 1] = tempDpEnd;
            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + "  ");
            }
            System.out.println();
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] < min) {
                min = dp[i];
            }
        }
        return min;
    }

    //状态压缩，自底向上
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size(), c;
        Integer dp[] = triangle.get(n - 1).toArray(new Integer[0]);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

}

