package com.solutions;

public class Solution_148 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        ListNode mid = split(listNode);
        ListNode left = sort(listNode);
        ListNode right = sort(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode header;
        ListNode headerTmp;
        ListNode leftTmp = left;
        ListNode rightTmp = right;
        if (leftTmp.val <= rightTmp.val) {
            header = leftTmp;
            headerTmp = leftTmp;
            leftTmp = leftTmp.next;
        } else {
            header = rightTmp;
            headerTmp = rightTmp;
            rightTmp = rightTmp.next;
        }
        while (leftTmp != null && rightTmp != null) {
            if (leftTmp.val <= rightTmp.val) {
                headerTmp.next = leftTmp;
                leftTmp = leftTmp.next;
            } else {
                headerTmp.next = rightTmp;
                rightTmp = rightTmp.next;
            }
            headerTmp = headerTmp.next;
        }
        if (leftTmp == null) {
            headerTmp.next = rightTmp;
        } else {
            headerTmp.next = leftTmp;
        }
        return header;
    }

    private ListNode split(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                ListNode tmp = slow.next;
                slow.next = null;
                slow = tmp;
            } else {
                slow = slow.next;
            }
        }
        return slow;
    }
}
