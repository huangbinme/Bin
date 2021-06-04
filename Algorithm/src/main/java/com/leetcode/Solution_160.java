package com.leetcode;

public class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aTmp = headA;
        ListNode bTmp = headB;
        while (aTmp != bTmp) {
            aTmp = aTmp == null ? headB : aTmp.next;
            bTmp = bTmp == null ? headA : bTmp.next;
        }
        return bTmp;
    }
}
