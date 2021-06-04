package com.leetcode;

import org.testng.annotations.Test;

public class Solution_160Test {

    @Test
    public void testGetIntersectionNode() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;

        Solution_160 solution_160 = new Solution_160();
        solution_160.getIntersectionNode(listNode1, listNode4);
    }

    @Test
    public void testTestGetIntersectionNode() {
    }
}