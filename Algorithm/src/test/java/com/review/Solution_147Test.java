package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_147Test {

    @Test
    public void testInsertionSortList() {
        Solution_147 solution147 = new Solution_147();
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = solution147.insertionSortList(l1);
        int i = 0;
    }
}