package com.review;

public class Solution_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode mockHead = new ListNode(-1);
        return sort(mockHead, head).next;
    }

    private ListNode sort(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        ListNode l2Next = l2.next;
        l2.next = null;
        ListNode l1Tmp = l1;
        while (!(l1Tmp.next == null || l2.val <= l1Tmp.next.val)) {
            l1Tmp = l1Tmp.next;
        }
        ListNode next = l1Tmp.next;
        l1Tmp.next = l2;
        l2.next = next;
        return sort(l1, l2Next);
    }
}
