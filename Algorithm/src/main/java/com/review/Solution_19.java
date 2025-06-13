package com.review;

public class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode slow = mockHead, fast = mockHead;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return mockHead.next;
    }
}
