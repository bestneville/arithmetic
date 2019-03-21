package com.neville.moduletest.myapplication.dataStructure.stack;

/**
 * 数组实现栈
 */

public class ArrayStack {
    public static void main(String[] args) {
        MyArrayStack<String> myArrayStack = new MyArrayStack<>();
        myArrayStack.push("1");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("2");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("3");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("4");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("5");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("6");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("7");
        System.out.print(myArrayStack.peek());
        myArrayStack.push("8");
        System.out.print(myArrayStack.peek());

        myArrayStack.pop();
        System.out.print(myArrayStack.peek());
        myArrayStack.pop();
        System.out.print(myArrayStack.peek());
        myArrayStack.pop();
        System.out.print(myArrayStack.peek());

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

        //获得栈顶元素
        private T peek() {
            return data[currentSize - 1];
        }
    }

}
