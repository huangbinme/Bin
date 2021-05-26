package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Deque<ListNode> aDeque = new LinkedList<>();
        Deque<ListNode> bDeque = new LinkedList<>();
        while (headA != null) {
            aDeque.offerLast(headA);
            headA = headA.next;
        }
        while (headB != null) {
            bDeque.offerLast(headB);
            headB = headB.next;
        }
        ListNode tmp = null;
        while (true) {
            ListNode a = aDeque.pollLast();
            ListNode b = bDeque.pollLast();
            if (a == b && !aDeque.isEmpty()) {
                tmp = a;
            } else {
                break;
            }
        }
        return tmp;
    }
}
