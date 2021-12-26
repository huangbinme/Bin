package com.leetcode;

public class Solution_147 {
    public ListNode insertionSortList(ListNode head) {
        return sort(new ListNode(Integer.MIN_VALUE), head).next;
    }

    private ListNode sort(ListNode sorted, ListNode unsorted) {
        if (unsorted == null) return sorted;
        ListNode find = sorted, nextUnsorted = unsorted.next;
        unsorted.next = null;
        while (!(find.next == null || find.next.val >= unsorted.val)) {
            find = find.next;
        }
        ListNode l = find.next;
        find.next = unsorted;
        unsorted.next = l;
        return sort(sorted, nextUnsorted);
    }
}
