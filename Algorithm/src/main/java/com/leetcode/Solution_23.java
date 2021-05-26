package com.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class Solution_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        lists = filterNull(lists);
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoList(head, lists[i]);
        }
        return head;
    }

    private ListNode[] filterNull(ListNode[] lists) {
        return Arrays.stream(lists).filter(Objects::nonNull).toArray(ListNode[]::new);
    }

    public ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
        ListNode head = new ListNode();
        ListNode headTmp = head;
        ListNode listNode1_tmp = listNode1;
        ListNode listNode2_tmp = listNode2;
        while (listNode1_tmp != null && listNode2_tmp != null) {
            if (listNode1_tmp.val <= listNode2_tmp.val) {
                headTmp.next = listNode1_tmp;
                listNode1_tmp = listNode1_tmp.next;
            } else {
                headTmp.next = listNode2_tmp;
                listNode2_tmp = listNode2_tmp.next;
            }
            headTmp = headTmp.next;
        }
        if (listNode1_tmp == null) {
            headTmp.next = listNode2_tmp;
        } else {
            headTmp.next = listNode1_tmp;
        }
        return head.next;
    }
}
