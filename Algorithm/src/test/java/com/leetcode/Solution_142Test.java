package com.leetcode;

import org.testng.annotations.Test;

public class Solution_142Test {

    @Test
    public void testDetectCycle() {
        Solution_142 solution_142 = new Solution_142();
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        solution_142.detectCycle(listNode1);
    }
}