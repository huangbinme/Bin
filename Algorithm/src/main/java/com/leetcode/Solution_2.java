package com.leetcode;

public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), tmp = ans;
        int guard = 0;
        while (l1 != null || l2 != null) {
            int cur = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + guard;
            guard = cur / 10;
            cur %= 10;
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(guard != 0) tmp.next = new ListNode(guard);
        return ans.next;
    }
}
