package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_61Test {

    @Test
    public void testRotateRight() {
        Solution_61 solution61 = new Solution_61();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        solution61.rotateRight(l1, 4);
    }
}