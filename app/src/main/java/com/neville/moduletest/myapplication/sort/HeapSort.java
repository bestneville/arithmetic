package com.neville.moduletest.myapplication.sort;

import com.neville.moduletest.myapplication.utils.MyUtils;

/**
 * 堆排序
 */
public class HeapSort {
    private static int[] data = {-1, 2, 8, 9, 6, 7, 4, 0};//-1是为了方便写堆代码空出来的，不参与排序

    public static void main(String[] args) {
        heapSort();
        MyUtils.logIntArr(data);
    }

    //排序的思路就是将堆顶和最后一个元素替换，再将之间的所有数据堆化，以此类推
    private static void heapSort() {
        if (data.length <= 1) return;
        buildHead(data.length - 1);
        int k = data.length - 1;
        while (k > 1) {
            swap(1, k);
            --k;
            heapify(k, 1);
        }
    }

    //建堆有两个思路：1.把数组从第1位开始，按照堆插入数据的思路
    //             2.从第一个非叶子节点堆化，一步步往上，这里采用第二个
    private static void buildHead(int count) {
        for (int i = count / 2; i >= 1; i--) {
            heapify(count, i);
        }

    }

    private static void heapify(int count, int i) {
        while (true) {
            int max = i;
            if (i * 2 <= count && data[i * 2] > data[i]) {
                max = i * 2;
            }
            if (i * 2 + 1 <= count && data[i * 2 + 1] > data[max]) {
                max = i * 2 + 1;
            }
            if (max == i) break;
            swap(i, max);
            i = max;
        }
    }

    private static void swap(int m, int n) {
        int k = data[m];
        data[m] = data[n];
        data[n] = k;
    }

}
