package com.leetcode;

import java.util.Random;

public class Solution_382 {

    ListNode listNode;

    Random random;

    public Solution_382(ListNode head) {
        listNode = head;
        random = new Random();
    }

    public int getRandom() {
        int c = 1, ans = 0;
        ListNode t = listNode;
        while (t != null) {
            ans = random.nextInt(c) == 0 ? t.val : ans;
            t = t.next;
            c++;
        }
        return ans;
    }
}
