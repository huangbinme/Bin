package com.leetcode;

public class Solution_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode listNode1 = list1, listNode2 = list1;
        for (int i = 0; i < a - 1; i++) {
            listNode1 = listNode1.next;
        }
        for (int i = 0; i < b; i++) {
            listNode2 = listNode2.next;
        }
        listNode1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = listNode2.next;
        return list1;
    }
}
