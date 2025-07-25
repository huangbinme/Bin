package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_402 {
    public String removeKdigits(String num, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (deque.isEmpty() || k == 0) {
                deque.offerLast(n);
            } else {
                while (!deque.isEmpty() && deque.peekLast() > n && k > 0) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(n);
            }
        }
        while (!deque.isEmpty() && k > 0) {
            deque.pollLast();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty() && deque.peekFirst().equals(0)) {
            deque.pollFirst();
        }
        while (!deque.isEmpty()) {
            ans.append(deque.pollFirst());
        }
        return ans.length() > 0 ? ans.toString() : "0";
    }
}
