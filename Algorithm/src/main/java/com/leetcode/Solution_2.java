package com.leetcode;

public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode nodeTmp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;
            int num = (l1Num + l2Num + carry) % 10;
            carry = (l1Num + l2Num + carry) / 10;
            ListNode listNode = new ListNode(num);
            if (head == null) {
                head = listNode;
                nodeTmp = listNode;
            } else {
                nodeTmp.next = listNode;
                nodeTmp = listNode;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head;
    }
}
