package com.leetcode.offer;

public class Solution_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode next = head, pre = dummy;
        while (next != null && next.val != val) {
            next = next.next;
            pre = pre.next;
        }
        pre.next = next == null ? null : next.next;
        return dummy.next;
    }
}
