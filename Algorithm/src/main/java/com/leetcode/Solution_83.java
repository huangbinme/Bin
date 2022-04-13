package com.leetcode;

public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next != null && tmp.next.val == tmp.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
