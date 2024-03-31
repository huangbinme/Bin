package com.leetcode;

public class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummyHead = new ListNode();
        reverse(dummyHead, head, k);
        return dummyHead.next;
    }

    private void reverse(ListNode l1, ListNode l2, int k) {
        // Before : l1 l2 l3 l4
        // After : l1 l3 l2 l4
        ListNode l3 = l2;
        for (int i = 0; i < k - 1; i++) {
            if (l3 == null) break;
            l3 = l3.next;
        }
        if (l3 == null) return;
        ListNode l4 = reverse(l2, l3);
        l1.next = l3;
        l2.next = l4;
        reverse(l2, l4, k);
    }

    private ListNode reverse(ListNode l1, ListNode l2) {
        ListNode tail = l2.next;
        ListNode tmp = l1.next;
        l1.next = null;
        reverse(l1, tmp, l2);
        return tail;
    }

    private void reverse(ListNode l1, ListNode l2, ListNode end) {
        if (l2 == end) {
            l2.next = l1;
            return;
        }
        ListNode tmp = l2.next;
        l2.next = l1;
        reverse(l2, tmp, end);
    }
}
