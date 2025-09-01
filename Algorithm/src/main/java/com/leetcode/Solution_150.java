package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int n1 = deque.pollLast(), n2 = deque.pollLast();
                deque.offerLast(n1 + n2);
            } else if ("-".equals(token)) {
                int n1 = deque.pollLast(), n2 = deque.pollLast();
                deque.offerLast(n2 - n1);
            } else if ("*".equals(token)) {
                int n1 = deque.pollLast(), n2 = deque.pollLast();
                deque.offerLast(n1 * n2);
            } else if ("/".equals(token)) {
                int n1 = deque.pollLast(), n2 = deque.pollLast();
                deque.offerLast(n2 / n1);
            } else {
                deque.offerLast(Integer.parseInt(token));
            }
        }
        return deque.pollLast();
    }
}
