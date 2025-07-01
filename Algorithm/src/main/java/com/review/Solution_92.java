package com.review;

public class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode p0 = mockHead;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null, next = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode l = next.next;
            next.next = pre;
            pre = next;
            next = l;
        }
        p0.next.next = next;
        p0.next = pre;
        return mockHead.next;
    }
}
