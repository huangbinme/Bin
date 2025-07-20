package com.review;

public class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode mock = new ListNode();
        reverseKGroup(mock, head, k);
        return mock.next;
    }

    private void reverseKGroup(ListNode l1, ListNode l2, int k) {
        //l1 l2
        //l1 (tail) l r  l3
        if (l2LessThanK(l2, k)) {
            l1.next = l2;
            return;
        }
        ListNode l = null, r = l2, tail = l2;
        for (int i = 0; i < k; i++) {
            ListNode rNext = r.next;
            r.next = l;
            l = r;
            r = rNext;
        }
        l1.next = l;
        reverseKGroup(tail, r, k);
    }

    private boolean l2LessThanK(ListNode l2, int k) {
        int i = 0;
        while (l2 != null) {
            l2 = l2.next;
            i++;
        }
        return i < k;
    }
}
