package com.review;

public class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l2Head = head.next, l1 = head, l2 = l2Head;
        while (l1 != null && l2 != null) {
            l1.next = l1.next.next;
            l2.next = l2.next != null ? l2.next.next : null;
            l1 = l1.next == null ? l1 : l1.next;//l1最终需要停在末端，来连接l2
            l2 = l2.next;
        }
        l1.next = l2Head;
        return head;
    }
}
