package com.leetcode;

public class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode preWithLeftNode = null;
        ListNode leftNode = head;
        for (int i = 1; i < left; i++) {
            if (i == left - 1) {
                preWithLeftNode = leftNode;
            }
            leftNode = leftNode.next;
        }

        ListNode nextWithRightNode;
        ListNode rightNode = head;
        for (int i = 1; i < right; i++) {
            rightNode = rightNode.next;
        }
        nextWithRightNode = rightNode.next;
        rightNode.next = null;
        reverse(leftNode);
        leftNode.next = nextWithRightNode;

        if (preWithLeftNode == null) {
            return rightNode;
        } else {
            preWithLeftNode.next = rightNode;
            return head;
        }
    }

    public ListNode reverse(ListNode listNode) {
        ListNode next = listNode.next;
        listNode.next = null;
        return reverse(listNode, next);
    }

    private ListNode reverse(ListNode listNode, ListNode next) {
        if (next == null) return listNode;
        ListNode tmp = next.next;
        next.next = listNode;
        return reverse(next, tmp);
    }
}
