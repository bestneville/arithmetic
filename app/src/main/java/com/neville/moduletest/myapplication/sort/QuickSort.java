package com.neville.moduletest.myapplication.sort;

import com.neville.moduletest.myapplication.utils.MyUtils;

/**
 * 快速排序
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] data = {2, 2, 9, 6, 7, 4, 0, 0, 10};
        quickSort(data, 0, data.length - 1);
        MyUtils.logIntArr(data);
    }

    private static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int p = partition(data, left, right);
            quickSort(data, left, p - 1);//注意这里，p-1而不是p，因为p点本身已经确定
            quickSort(data, p + 1, right);
        }
    }


    private static int partition(int[] data, int left, int right) {
        int pivot = data[right];
        int i = left, j = left;
        while (j < right) {
            if (data[i] < pivot) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
            }
            j++;
        }
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return i;
    }
}
