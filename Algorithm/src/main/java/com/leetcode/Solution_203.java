package com.leetcode;

public class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode empty = new ListNode(val - 1);
        empty.next = head;
        ListNode node = empty;
        while (node != null) {
            if (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return empty.next;
    }
}
