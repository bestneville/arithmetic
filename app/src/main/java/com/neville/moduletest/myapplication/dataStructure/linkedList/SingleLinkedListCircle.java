package com.neville.moduletest.myapplication.dataStructure.linkedList;

import com.neville.moduletest.myapplication.utils.LinkedListUtil;
import com.neville.moduletest.myapplication.utils.Node;

/**
 * 单链表环的检测
 */
public class SingleLinkedListCircle {
    public static void main(String[] args) {
        Node header = LinkedListUtil.preNodeList(1, 2, 3, 4, 5, 6);
        header.next.next.next.next.next = header;
        boolean hasCircle = hasCircle(header);
        System.out.print(hasCircle);
    }

    //这个方法存在问题。如果链表够长，而环又足够小，那么快指针将永远不会追上慢指针
    //所以，快慢指针只适合用于环出现在链表尾部的情况，也就是单链表环的问题，而无法解决链表存在循环的问题。
    public static boolean hasCircle(Node header) {
        Node slow, fast;
        slow = fast = header;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
