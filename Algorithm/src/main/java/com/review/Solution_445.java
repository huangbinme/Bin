package com.review;

public class Solution_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reverse = reverse(l1), l2Reverse = reverse(l2);
        ListNode mockHead = new ListNode(), move = mockHead;
        int carry = 0;
        while (l1Reverse != null || l2Reverse != null || carry != 0) {
            int l1Num = l1Reverse != null ? l1Reverse.val : 0;
            int l2Num = l2Reverse != null ? l2Reverse.val : 0;
            int curNum = carry + l1Num + l2Num;
            carry = curNum / 10;
            ListNode curNode = new ListNode(curNum % 10);
            move.next = curNode;
            move = move.next;
            l1Reverse = l1Reverse != null ? l1Reverse.next : null;
            l2Reverse = l2Reverse != null ? l2Reverse.next : null;
        }
        ListNode l3 = mockHead.next;
        mockHead.next = null;
        return reverse(l3);
    }

    private ListNode reverse(ListNode listNode) {
        ListNode l1 = null, l2 = listNode;
        while (l2 != null) {
            ListNode l2Next = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = l2Next;
        }
        return l1;
    }
}
