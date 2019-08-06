package com.neville.moduletest.myapplication.leetCode;


/**
 * 删除排序数组中的重复项
 */

public class LeetCode26 {
    public static void main(String[] args) {
        int[] nums = {1};
        int len = removeDuplicates(nums);
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                int temp = nums[index + 1];
                nums[++index] = nums[i];
                nums[i] = temp;
            }
        }
        return index + 1;
    }

}

