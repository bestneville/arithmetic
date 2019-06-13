package com.neville.moduletest.myapplication.dataStructure.heap;

/**
 * Created by niewei on 2019/6/13.
 */

public class Heap {

    public static void main(String[] args) {
        MyHeap heap = new MyHeap(14);
        heap.insert(33);
        heap.insert(27);
        heap.insert(21);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(19);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.insert(12);

        heap.removeMax();
        heap.removeMax();
        heap.log();
    }


    //大顶堆
    static class MyHeap {
        private int[] data;
        private int count;

        public MyHeap(int length) {
            data = new int[length + 1];
            count = 0;
        }

        //自下而上堆化
        public void insert(int a) {
            if (count >= data.length - 1) return;//堆已满
            ++count;
            data[count] = a;
            int i = count;
            while (i / 2 > 0 && data[i] > data[i / 2]) {
                //交换位置 i和i/2
                swap(i, i / 2);
                i = i / 2;
            }

        }

        public void log() {
            for (int i = 1; i <= count; i++) {
                System.out.print(data[i] + ",");
            }
            System.out.println();
        }

        //移除栈顶，先替换堆顶元素和最后一个元素，再自上而下堆化
        public void removeMax() {
            if (count == 0) return;//已经没有元素
            data[1] = data[count];
            --count;
            heapify();
        }

        //自上而下堆化
        private void heapify() {
            int i = 1;
            while (true) {
                int max = i;
                if (i * 2 < count && data[i * 2] > data[i]) {
                    max = i * 2;
                }
                if (i * 2 + 1 < count && data[i * 2 + 1] > data[max]) {
                    max = i * 2 + 1;
                }
                if (max == i) break;//说明没有比该元素大的左右元素，退出循环
                swap(i, max);
                i = max;
            }
        }

        private void swap(int m, int n) {
            int k = data[m];
            data[m] = data[n];
            data[n] = k;
        }
    }
}
