package com.leetcode;

import java.util.Random;

public class Solution_382 {

    ListNode head;
    Random random;

    public Solution_382(ListNode head) {
        this.random = new Random();
        this.head = head;
    }

    public int getRandom() {
        int ans = 0, count = 0;
        ListNode l = head;
        while (l != null) {
            count++;
            ans = random.nextInt(count) == 0 ? l.val : ans;
            l = l.next;
        }
        return ans;
    }
}
