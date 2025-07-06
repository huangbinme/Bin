package com.review;

public class Solution_143 {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            if (fast != null) slow = slow.next;
        }
        ListNode reverseHead = slow.next;
        slow.next = null;
        ListNode p1 = head, p2 = reverse(reverseHead);
        while (p2 != null) {
            ListNode p1Next = p1.next, p2Next = p2.next;
            p1.next = p2;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
    }

    private ListNode reverse(ListNode listNode) {
        ListNode pre = null, next = listNode;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return pre;
    }
}
