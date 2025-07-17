package com.review;

import org.testng.annotations.Test;

public class Solution_148Test {

    @Test
    public void testSortList() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution_148 solution148 = new Solution_148();
        ListNode listNode = solution148.sortList(l1);
        int i = 0;
    }
}