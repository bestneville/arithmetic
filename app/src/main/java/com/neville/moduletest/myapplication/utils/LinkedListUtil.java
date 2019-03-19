package com.neville.moduletest.myapplication.utils;

/**
 * Created by niewei on 2019/3/19.
 */

public class LinkedListUtil {

    public static Node preNodeList(int... data) {
        Node header = new Node(data[0]);
        Node pre = header;
        for (int i = 1; i < data.length; i++) {
            Node next = new Node(data[i]);
            pre.next = next;
            pre = next;
        }

        return header;
    }

    public static void logNodeList(Node header) {
        Node next = header;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
    }
}
