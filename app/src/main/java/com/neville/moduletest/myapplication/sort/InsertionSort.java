package com.neville.moduletest.myapplication.sort;

import com.neville.moduletest.myapplication.utils.MyUtils;

/**
 * 插入排序
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {2, 2, 9, 6, 7, 4, 0, 0, 10};
        data = insertionSort(data);
        MyUtils.logIntArr(data);
    }

    private static int[] insertionSort(int[] data) {
        if (data.length <= 1) return data;
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            //注意for循环结束，多执行了一次j--
            data[j + 1] = value;
        }
        return data;
    }
}
