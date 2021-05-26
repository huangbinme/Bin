package com.leetcode;

import junit.framework.TestCase;

public class Solution_21Test extends TestCase {

    public void testMergeTwoLists() {
        ListNode l1 = get(1);
        ListNode l2 = get(2);
        ListNode l3 = get(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = get(1);
        ListNode l5 = get(3);
        ListNode l6 = get(4);
        l4.next = l5;
        l5.next = l6;

        Solution_21 solution_21 = new Solution_21();
        ListNode re = solution_21.mergeTwoLists(l1,l4);
        System.out.println("su");
    }

    public ListNode get(int num){
        return new ListNode(num);
    }
}