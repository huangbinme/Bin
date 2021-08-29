package com.leetcode.offer;

public class Solution_6 {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int[] ans = new int[count];
        tmp = head;
        int index = count - 1;
        while (tmp != null) {
            ans[index--] = tmp.val;
            tmp = tmp.next;
        }
        return ans;
    }
}
