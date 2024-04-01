package com.leetcode;

public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        ListNode quick = head, slow = head;
        while (true) {
            slow = slow != null ? slow.next : null;
            quick = quick != null ? quick.next : null;
            quick = quick != null ? quick.next : null;
            if (quick == null || slow == quick) break;
        }
        return slow == quick && slow != null;
    }
}
