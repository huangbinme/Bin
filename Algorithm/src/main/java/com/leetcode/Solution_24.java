package com.leetcode;

public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode mock = new ListNode();
        mock.next = head;
        swapPairs(mock, head, head.next);
        return mock.next;
    }

    private void swapPairs(ListNode p1, ListNode p2, ListNode p3) {
        if (p1 == null || p2 == null || p3 == null) return;
        ListNode p3Next = p3.next;
        p1.next = p3;
        p3.next = p2;
        p2.next = p3Next;
        swapPairs(p2, p2.next, p2.next == null ? null : p2.next.next);
    }
}
