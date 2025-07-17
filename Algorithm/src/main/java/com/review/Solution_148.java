package com.review;

public class Solution_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode l = sortList(head);
        ListNode r = sortList(mid);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;
        ListNode mockhead = new ListNode(), tail = mockhead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                ListNode lnext = l.next;
                tail.next = l;
                l.next = null;
                tail = tail.next;
                l = lnext;
            } else {
                ListNode rnext = r.next;
                tail.next = r;
                r.next = null;
                tail = tail.next;
                r = rnext;
            }
        }
        tail.next = l != null ? l : r;
        return mockhead.next;
    }

    private ListNode getMid(ListNode listNode) {
        ListNode slow = listNode, fast = listNode, slowPre = null;
        while (fast != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        slowPre.next = null;
        return slow;
    }
}
