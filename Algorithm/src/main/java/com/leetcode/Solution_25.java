package com.leetcode;

public class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode mock = new ListNode();
        mock.next = head;
        reverse(mock, k);
        return mock.next;
    }

    private void reverse(ListNode groupHead, int k) {
        if (groupHead == null) return;
        ListNode reverseHead = groupHead.next;
        ListNode reverseTail = groupHead;
        for (int i = 0; i < k; i++) {
            if (reverseTail.next == null) return;
            reverseTail = reverseTail.next;
        }
        ListNode[] reverseRes = reverse(reverseHead, reverseTail);
        groupHead.next = reverseRes[0];
        reverse(reverseRes[1], k);
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return new ListNode[]{tail, head};
    }
}
