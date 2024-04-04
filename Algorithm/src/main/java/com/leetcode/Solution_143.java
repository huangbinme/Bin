package com.leetcode;

public class Solution_143 {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode mid = findMid(head);
        ListNode reverseStart = mid.next;
        mid.next = null;
        ListNode l2 = reverse(reverseStart);
        merge(head, l2);
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    private ListNode reverse(ListNode start) {
        ListNode l1 = null;
        ListNode l2 = start;
        while (l2 != null) {
            ListNode l3 = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = l3;
        }
        return l1;
    }
}
