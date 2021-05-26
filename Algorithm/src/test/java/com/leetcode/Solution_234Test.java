package com.leetcode;

import org.testng.annotations.Test;

public class Solution_234Test {

    @Test
    public void testIsPalindrome() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution_234 solution_234 = new Solution_234();
        solution_234.isPalindrome(listNode1);
    }
}