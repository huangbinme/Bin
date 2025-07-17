package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_82Test {

    @Test
    public void testDeleteDuplicates() {
        Solution_82 solution82 = new Solution_82();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = solution82.deleteDuplicates(l1);
        int i = 0;
    }
}