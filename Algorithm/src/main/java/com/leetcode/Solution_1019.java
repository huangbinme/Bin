package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekFirst() <= list.get(i)){
                deque.pollFirst();
            }
            if(!deque.isEmpty()){
                ans[i] = deque.peekFirst();
            }
            deque.offerFirst(list.get(i));
        }
        return ans;
    }
}
