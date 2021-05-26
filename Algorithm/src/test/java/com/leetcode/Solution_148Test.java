package com.leetcode;

import org.testng.annotations.Test;

public class Solution_148Test {

    @Test
    public void testSortList() {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution_148 solution_148 = new Solution_148();
        solution_148.sortList(listNode1);
    }
}