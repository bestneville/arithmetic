package com.neville.moduletest.myapplication.leetCode;

/**
 * 两数相加
 */

public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l10 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l10.next = l11;
        l11.next = l12;

        ListNode l20 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l20.next = l21;
        l21.next = l22;

        ListNode result = mergeTwoLists(l10, l20);
        while (result != null) {
            System.out.println(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

