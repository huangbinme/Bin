package com.leetcode;

public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head.next;
        head.next = null;
        return reverse(head, tmp);
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        if (next == null) return pre;
        ListNode tmp = next;
        next = next.next;
        tmp.next = pre;
        return reverse(tmp, next);
    }
}
