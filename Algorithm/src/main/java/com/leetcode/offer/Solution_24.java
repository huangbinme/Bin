package com.leetcode.offer;

public class Solution_24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode next = head.next;
        pre.next = null;
        return reverse(pre, next);
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        if(next == null) return pre;
        ListNode newNext = next.next;
        next.next = pre;
        return reverse(next, newNext);
    }
}
