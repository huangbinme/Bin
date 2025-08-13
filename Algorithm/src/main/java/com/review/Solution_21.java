package com.review;

public class Solution_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode mock = new ListNode(), move = mock;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                move.next = list1;
                list1 = list1.next;
            } else {
                move.next = list2;
                list2 = list2.next;
            }
            move = move.next;
        }
        move.next = list1 != null ? list1 : list2;
        return mock.next;
    }
}
