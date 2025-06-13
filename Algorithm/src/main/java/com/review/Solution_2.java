package com.review;

public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tmp = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = v >= 10 ? 1 : 0;
            v %= 10;
            tmp.next = new ListNode(v);
            tmp = tmp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            tmp.next = new ListNode(1);
        }
        return head.next;
    }
}
