package com.neville.moduletest.myapplication.dataStructure.stack;

import com.neville.moduletest.myapplication.utils.Node;

/**
 * 数组实现栈
 */

public class LinkedListStack {
    public static void main(String[] args) {
        MyLinkedListStack myLinkedListStack = new MyLinkedListStack();
        myLinkedListStack.push(1);
        System.out.print(myLinkedListStack.peek());
        myLinkedListStack.push(2);
        System.out.print(myLinkedListStack.peek());
        myLinkedListStack.push(3);
        System.out.print(myLinkedListStack.peek());
        myLinkedListStack.push(4);
        System.out.print(myLinkedListStack.peek());
        myLinkedListStack.push(5);
        System.out.print(myLinkedListStack.peek());

        myLinkedListStack.pop();
        System.out.print(myLinkedListStack.peek());
        myLinkedListStack.pop();
        System.out.print(myLinkedListStack.peek());
        myLinkedListStack.pop();
        System.out.print(myLinkedListStack.peek());

    }

    static class MyLinkedListStack {
        private Node top;

        public MyLinkedListStack() {
        }

        //入栈
        private void push(int value) {
            Node newTop = new Node(value);
            newTop.next = top;
            top = newTop;
        }

        //出栈
        private int pop() {
            if (top == null) return -1;
            Node next = top.next;
            top.next = null;
            top = next;
            return next.value;
        }

        //获得栈顶元素
        private int peek() {
            return top.value;
        }
    }

}
