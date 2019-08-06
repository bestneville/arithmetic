package com.neville.moduletest.myapplication.leetCode;


/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */

public class LeetCode303 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);

        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
    }

    //其实这题需要考虑多次调用的问题，要么缓存range到map，要么缓存sum，利用sum[j + 1] - sum[i]求值
    static class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }

}

