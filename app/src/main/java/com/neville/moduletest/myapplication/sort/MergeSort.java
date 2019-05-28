package com.neville.moduletest.myapplication.sort;

import com.neville.moduletest.myapplication.utils.MyUtils;

/**
 * 归并排序
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] data = {2, 2, 9, 6, 7, 4, 0, 0, 10};
        int[] temp = new int[data.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(data, 0, data.length - 1, temp);
        MyUtils.logIntArr(data);
    }

    private static void mergeSort(int[] data, int left, int right, int[] temp) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(data, left, middle, temp);
            mergeSort(data, middle + 1, right, temp);
            merge(data, left, middle, right, temp);
        }
    }

    private static void merge(int[] data, int left, int middle, int right, int[] temp) {
        int i = left;//左序列指针
        int j = middle + 1;//右序列指针
        int c = 0;//临时数组指针
        while (i <= middle && j <= right) {
            if (data[i] <= data[j]) {
                temp[c++] = data[i++];
            } else {
                temp[c++] = data[j++];
            }
        }
        while (i <= middle) {
            temp[c++] = data[i++];
        }
        while (j <= right) {
            temp[c++] = data[j++];
        }
        c = 0;
        while (left <= right) {
            data[left++] = temp[c++];
        }
    }
}
