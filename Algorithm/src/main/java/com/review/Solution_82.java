package com.review;

public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode mock = new ListNode();
        mock.next = head;
        ListNode l1 = mock, l2 = mock.next;
        while (l2 != null) {
            if(l2.next == null || l2.next.val != l2.val){
                l1 = l1.next;
                l2 = l2.next;
            }else {
                int l2V = l2.val;
                ListNode move = l2;
                while (move != null && move.val == l2V) move = move.next;
                l1.next = move;
                l2 = move;
            }
        }
        return mock.next;
    }
}
