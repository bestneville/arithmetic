package com.neville.moduletest.myapplication.leetCode;

/**
 * 两数相加
 */

public class LeetCode02 {
    public static void main(String[] args) {
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l10.next = l11;
        l11.next = l12;

        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l20.next = l21;
        l21.next = l22;

        ListNode result = addTwoNumbers(l10, l20);
        while (result != null) {
            System.out.println(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newListNode = new ListNode(0);
        ListNode temp = newListNode;
        int over = 0;
        while (l1 != null || l2 != null) {
            int result = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + over;
            over = result / 10;
            int k = result % 10;
            temp.next = new ListNode(k);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (over != 0) {
            temp.next = new ListNode(over);
        }
        return newListNode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}

