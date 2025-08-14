package com.leetcode;

public class Solution_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode mockL1 = new ListNode(), mockL2 = new ListNode();
        ListNode l1Move = mockL1, l2Move = mockL2;
        while (head != null) {
            if (head.val >= x) {
                ListNode next = head.next;
                head.next = null;
                l2Move.next = head;

                //移动指针
                l2Move = l2Move.next;
                head = next;
            } else {
                ListNode next = head.next;
                head.next = null;
                l1Move.next = head;
                l1Move = l1Move.next;
                head = next;
            }
        }
        l1Move.next = mockL2.next;
        return mockL1.next;
    }
}
