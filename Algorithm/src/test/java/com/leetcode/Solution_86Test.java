package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_86Test {

    @Test
    public void testPartition() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Solution_86 s = new Solution_86();
        ListNode partition = s.partition(l1, 3);
    }
}