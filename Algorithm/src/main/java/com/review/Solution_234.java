package com.review;

public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        slow = reverse(slow);
        while (slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode left = null, right = slow;
        while (right != null) {
            ListNode next = right.next;
            right.next = left;
            left = right;
            right = next;
        }
        return left;
    }
}
