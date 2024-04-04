package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.add(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode l = queue.poll();
            tmp.next = l;
            ListNode lNext = l.next;
            l.next = null;
            tmp = tmp.next;
            if (lNext != null) queue.offer(lNext);
        }
        return dummy.next;
    }
}
