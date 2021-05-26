package com.leetcode;

import org.testng.annotations.Test;

public class Solution_92Test {

    @Test
    public void testReverseBetween() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution_92 solution_92 = new Solution_92();
        solution_92.reverseBetween(listNode1, 2, 4);
    }
}