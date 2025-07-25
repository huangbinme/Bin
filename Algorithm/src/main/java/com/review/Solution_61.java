package com.review;

public class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int count = 0;
        ListNode moveNode = head;
        while (moveNode != null) {
            count++;
            moveNode = moveNode.next;
        }
        int move = k % count;
        if (move == 0) return head;
        ListNode l1 = null, l2 = head;
        for (int i = 0; i < count - move; i++) {
            l1 = l2;
            l2 = l2.next;
        }
        l1.next = null;
        ListNode newHead = l2;
        while (l2.next != null) l2 = l2.next;
        l2.next = head;
        return newHead;
    }
}
