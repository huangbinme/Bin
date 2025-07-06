package com.review;

public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
            if (slow == fast) break;
        }
        if (slow == null || fast == null) return null;
        ListNode next = head;
        while (next != slow) {
            next = next.next;
            slow = slow.next;
        }
        return next;
    }
}
