package com.leetcode.offer;

public class Solution_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }
        return tmpA;
    }
}
