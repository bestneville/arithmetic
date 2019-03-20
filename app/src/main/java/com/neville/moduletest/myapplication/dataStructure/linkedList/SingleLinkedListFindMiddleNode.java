package com.neville.moduletest.myapplication.dataStructure.linkedList;

import com.neville.moduletest.myapplication.utils.LinkedListUtil;
import com.neville.moduletest.myapplication.utils.Node;

/**
 * 非空的单向链表，返回其中间节点。如果有两个中间结点，返回第二个。
 */
public class SingleLinkedListFindMiddleNode {
    public static void main(String[] args) {
        Node header = LinkedListUtil.preNodeList(1, 2, 3, 4, 5);
        Node middle = find(header);
        System.out.print(middle.value);
    }

    //快慢指针
    public static Node find(Node header) {
        if (header == null || header.next == null) {
            return header;
        }
        Node slow = header;
        Node fast = header.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
