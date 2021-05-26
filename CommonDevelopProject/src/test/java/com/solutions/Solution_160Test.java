package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_160Test {

    @Test
    public void testGetIntersectionNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(3);
        listNode6.next = listNode4;
        Solution_160 solution_160 = new Solution_160();
        solution_160.getIntersectionNode(listNode1,listNode6);
    }
}