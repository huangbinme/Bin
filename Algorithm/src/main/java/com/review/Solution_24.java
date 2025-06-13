package com.review;

public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode mockHead = new ListNode();
        mockHead.next = swap(head);
        return mockHead.next;
    }

    private ListNode swap(ListNode listNode) {
        if (listNode == null || listNode.next == null) return listNode;
        ListNode l1 = listNode.next, l2 = listNode, l3 = listNode.next.next;
        l1.next = l2;
        l2.next = swap(l3);
        return l1;
    }
}
