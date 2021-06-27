package com.leetcode;

public class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode oddHead = head, oddTail = head;
        ListNode evenHead = head.next, evenTail = head.next;

        ListNode node = evenTail.next;
        while (node != null) {

            evenTail.next = node.next;
            evenTail = evenTail.next;

            oddTail.next = node;
            node.next = evenHead;
            oddTail = oddTail.next;

            node = evenTail != null ? evenTail.next : null;
        }
        return oddHead;
    }
}
