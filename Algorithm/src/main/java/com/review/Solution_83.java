package com.review;

public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = head;
        while (t != null) {
            if (t.next != null && t.next.val == t.val) {
                t.next = t.next.next;
            } else {
                t = t.next;
            }
        }
        return head;
    }
}
