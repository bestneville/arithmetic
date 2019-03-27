package com.neville.moduletest.myapplication.sort;

import com.neville.moduletest.myapplication.utils.MyUtils;

/**
 * 冒泡排序
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {2, 2, 9, 6, 7, 4, 0, 0, 10};
        data = bubbleSort(data);
        MyUtils.logIntArr(data);
    }

    private static int[] bubbleSort(int[] data) {
        if (data.length <= 1) return data;
        for (int i = 0; i < data.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;//表示有数据交换
                }
            }
            if (!flag) break;//没有数据交换，提前退出
        }
        return data;
    }
}
