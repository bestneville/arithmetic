package com.neville.moduletest.myapplication.dataStructure.linkedList;

import com.neville.moduletest.myapplication.utils.LinkedListUtil;
import com.neville.moduletest.myapplication.utils.Node;

/**
 * 两个有序单链表合并
 */
public class SingleLinkedListMerge {
    public static void main(String[] args) {
        Node header1 = LinkedListUtil.preNodeList(1, 3, 4, 6);
        Node header2 = LinkedListUtil.preNodeList(1, 2, 5, 6, 9, 10);
        Node newHeader = merge1(header1, header2);
        LinkedListUtil.logNodeList(newHeader);
    }

    //递归实现
    public static Node merge1(Node header1, Node header2) {
        if (header1 == null) {
            return header2;
        }
        if (header2 == null) {
            return header1;
        }
        Node newHeader = null;
        if (header1.value <= header2.value) {
            newHeader = header1;
            newHeader.next = merge1(header1.next, header2);
        } else {
            newHeader = header2;
            newHeader.next = merge1(header1, header2.next);
        }
        return newHeader;

    }


    //自己实现的垃圾代码
    public static Node merge2(Node header1, Node header2) {
        Node newHeader = null;
        if (header1 == null) {
            return header2;
        }
        if (header2 == null) {
            return header1;
        }
        Node current = null;
        while (header1 != null && header2 != null) {
            if (header1.value <= header2.value) {
                if (newHeader == null) {
                    newHeader = header1;
                    current = newHeader;
                } else {
                    current.next = header1;
                    current = current.next;
                }
                header1 = header1.next;
                if (header1 == null) {
                    current.next = header2;
                }
            } else {
                if (newHeader == null) {
                    newHeader = header2;
                    current = newHeader;
                } else {
                    current.next = header2;
                    current = current.next;
                }
                header2 = header2.next;
                if (header2 == null) {
                    current.next = header1;
                }
            }
        }
        return newHeader;
    }
}
