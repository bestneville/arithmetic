package com.neville.moduletest.myapplication.dataStructure.stack;

/**
 * 数组实现栈
 */

public class ArrayStack {
    public static void main(String[] args) {
        MyArrayStack<String> myArrayStack = new MyArrayStack<>();
        myArrayStack.push("1");
        myArrayStack.push("2");
        myArrayStack.push("3");
        myArrayStack.push("4");
        myArrayStack.push("5");
        myArrayStack.push("6");
        myArrayStack.push("7");
        myArrayStack.push("8");
        myArrayStack.log();

        myArrayStack.pop();
        myArrayStack.pop();
        myArrayStack.pop();
        myArrayStack.log();

    }

    static class MyArrayStack<T> {
        private static final int DEFAULT_SIZE = 5;
        private int currentSize;
        private T[] data;


        public MyArrayStack() {
            currentSize = 0;
            ensureCapacity(DEFAULT_SIZE);
        }

        //初始化/扩容
        private void ensureCapacity(int newCapacity) {
            if (newCapacity < currentSize) return;
            T[] oldData = data;
            data = (T[]) new Object[newCapacity];
            for (int i = 0; i < currentSize; i++) {
                data[i] = oldData[i];
            }
        }

        //入栈
        private void push(T value) {
            if (currentSize == data.length) {
                ensureCapacity(currentSize * 2);
            }
            data[currentSize++] = value;
        }

        //出栈
        private T pop() {
            if (currentSize == 0) return null;
            T popValue = data[currentSize - 1];
            data[currentSize--] = null;
            return popValue;
        }

        private void log() {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(data[i]);
            }
        }
    }

}
