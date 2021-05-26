package com.leetcode;

import junit.framework.TestCase;

public class Solution_138Test extends TestCase {

    public void testCopyRandomList() {
        Solution_138 solution_138 = new Solution_138();
        Solution_138.Node head1 = new Solution_138.Node(7);
        Solution_138.Node head2 = new Solution_138.Node(13);
        Solution_138.Node head3 = new Solution_138.Node(11);
        Solution_138.Node head4 = new Solution_138.Node(10);
        Solution_138.Node head5 = new Solution_138.Node(1);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        solution_138.copyRandomList(head1);
    }
}