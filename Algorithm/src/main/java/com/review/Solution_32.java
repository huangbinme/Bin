package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_32 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.offerLast(i);
            } else {
                if (deque.size() == 1) {
                    deque.pollLast();
                    deque.offerLast(i);
                } else {
                    int p = deque.pollLast();
                    ans = Math.max(ans, i - p + 1);
                    ans = Math.max(ans, i - deque.peekLast());
                }
            }
        }
        return ans;
    }
}
