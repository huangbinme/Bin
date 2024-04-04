package com.leetcode;

public class Solution_92 {

    ListNode l4;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        // l1 (l2 l3) l4
        // l1 (l3 l2) l4
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = dummy;
        ListNode l1 = null, l2 = null, l3 = null;
        for (int i = 0; i < right; i++) {
            if (i == left - 1) l1 = tmp;
            if (i == left) l2 = tmp;
            tmp = tmp.next;
        }
        l3 = tmp;
        ListNode l2_next = l2.next;
        l2.next = null;
        l1.next = reverse(l2, l2_next, l3);
        l2.next = l4;
        return dummy.next;
    }

    private ListNode reverse(ListNode pre, ListNode next, ListNode tail) {
        if (next == tail) {
            l4 = next.next;
            next.next = pre;
            return next;
        }
        ListNode tmp = next.next;
        next.next = pre;
        return reverse(next, tmp, tail);
    }
}
