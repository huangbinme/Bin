package com.leetcode.offer.offer2;

public class Solution_24 {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode listNode = head.next;
        head.next = null;
        return reverse(head, listNode);
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        if (next == null) return pre;
        ListNode tmp = next.next;
        next.next = pre;
        return reverse(next, tmp);
    }
}
