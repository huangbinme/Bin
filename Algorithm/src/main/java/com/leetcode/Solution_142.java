package com.leetcode;

public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null || slow == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
