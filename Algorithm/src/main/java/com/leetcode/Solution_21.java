package com.leetcode;

public class Solution_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            }else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
