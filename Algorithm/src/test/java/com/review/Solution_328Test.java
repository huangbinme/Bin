package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_328Test {

    @Test
    public void testOddEvenList() {
        Solution_328 solution328 = new Solution_328();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        solution328.oddEvenList(l1);
    }
}