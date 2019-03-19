package com.neville.moduletest.myapplication.dataStructure.linkedList;

import com.neville.moduletest.myapplication.utils.LinkedListUtil;
import com.neville.moduletest.myapplication.utils.Node;

import java.util.LinkedList;

/**
 * Created by niewei on 2018/9/26.
 */
//单链表反转
public class SingleLinkedListReverse {
    public static void main(String[] args) {
        Node header = LinkedListUtil.preNodeList(1, 2, 3, 4, 5, 6);
        Node reverseHeader = null;
//        reverseHeader = reverseNodeList1(header);
        reverseHeader = reverseNodeList2(header);
        LinkedListUtil.logNodeList(reverseHeader);


//        LinkedList<Node> list = new LinkedList<>();
//        list.add(new Node(1));
//        list.add(new Node(2));
//        list.add(new Node(3));
//        list.add(new Node(4));
//        list.add(new Node(5));
//        list = reverseLinkedList(list);
//        for (Node n : list) {
//            System.out.print(n.value);
//        }
    }


    //遍历法  反转
    private static Node reverseNodeList1(Node header) {
        Node pre = null;
        Node next = null;
        while (header != null) {
            next = header.next;
            header.next = pre;
            pre = header;
            header = next;
        }
        return pre;
    }

    //递归法  反转
    private static Node reverseNodeList2(Node header) {
        if (header == null || header.next == null) {
            return header;
        }
        Node temp = header.next;
        Node newHeader = reverseNodeList2(header.next);
        temp.next = header;
        header.next = null;
        return newHeader;
    }

    //采用LinkedList实现反转
    private static LinkedList<Node> reverseLinkedList(LinkedList<Node> linkedList) {
        LinkedList<Node> newLinkedList = new LinkedList<>();
        for (Node i : linkedList) {
            newLinkedList.add(0, i);
        }
        return newLinkedList;
    }

}






