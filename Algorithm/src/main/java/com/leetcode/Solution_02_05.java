package com.leetcode;

public class Solution_02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), move = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;
            int sum = l1Num + l2Num + carry;
            int nodeNum = sum % 10;
            carry = sum / 10;
            ListNode cur = new ListNode(nodeNum);
            move.next = cur;
            move = move.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return ans.next;
    }
}
