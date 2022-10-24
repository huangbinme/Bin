package com.review;

public class Solution_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), tmp = ans;
        int guard = 0;
        while (l1 != null || l2 != null) {
            ListNode next = new ListNode();
            next.val = getNum(l1) + getNum(l2) + guard;
            guard = next.val / 10;
            next.val = next.val % 10;
            tmp.next = next;
            tmp = move(tmp);
            l1 = move(l1);
            l2 = move(l2);
        }
        if (guard != 0) {
            tmp.next = new ListNode(guard);
        }
        return ans.next;
    }

    private ListNode move(ListNode listNode) {
        return listNode != null ? listNode.next : null;
    }

    private int getNum(ListNode listNode) {
        return listNode == null ? 0 : listNode.val;
    }
}
