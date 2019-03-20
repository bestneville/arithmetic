package com.neville.moduletest.myapplication.dataStructure.linkedList;

import com.neville.moduletest.myapplication.utils.LinkedListUtil;
import com.neville.moduletest.myapplication.utils.Node;

/**
 * 单链表 删除倒数第N个节点
 */
public class SingleLinkedListDelete {
    public static void main(String[] args) {
        Node header = LinkedListUtil.preNodeList(1, 2, 3, 4, 5, 6);
        header = delete(header, 4);
        LinkedListUtil.logNodeList(header);
    }

    //采用前后指针，相隔N步，后指针到底链表尾部，前指针正好是倒数第N个
    public static Node delete(Node header, int n) {
        Node pre, cur;
        pre = cur = header;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            //删除头节点
            return header.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return header;
    }
}
