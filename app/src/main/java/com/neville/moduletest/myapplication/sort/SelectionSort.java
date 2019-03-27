package com.neville.moduletest.myapplication.sort;

import com.neville.moduletest.myapplication.utils.MyUtils;

/**
 * 选择排序
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {2, 2, 9, 6, 7, 4, 0};
        data = selectionSort(data);
        MyUtils.logIntArr(data);
    }

    private static int[] selectionSort(int[] data) {
        if (data.length <= 1) return data;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }
}
