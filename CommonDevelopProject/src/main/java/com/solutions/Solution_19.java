package com.solutions;

public class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = findFast(head, n);
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    private ListNode findFast(ListNode head, int n) {
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;
    }
}
