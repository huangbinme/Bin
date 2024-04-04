package com.leetcode;

public class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != tmpB) {
            if (tmpA.next == null && tmpB.next == null) return null;
            tmpA = tmpA.next != null ? tmpA.next : headB;
            tmpB = tmpB.next != null ? tmpB.next : headA;
        }
        return tmpA;
    }
}
