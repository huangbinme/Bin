package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_92Test {

    @Test
    public void testReverseBetween() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution_92 solution92 = new Solution_92();
        solution92.reverseBetween(l1, 2, 4);
    }
}