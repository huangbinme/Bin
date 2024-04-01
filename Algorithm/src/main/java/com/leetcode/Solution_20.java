package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') deque.offerLast(c);
            if (c == ')') {
                if (!deque.isEmpty() && deque.peekLast() == '(') {
                    deque.pollLast();
                } else {
                    return false;
                }
            }
            if (c == ']') {
                if (!deque.isEmpty() && deque.peekLast() == '[') {
                    deque.pollLast();
                } else {
                    return false;
                }
            }
            if (c == '}') {
                if (!deque.isEmpty() && deque.peekLast() == '{') {
                    deque.pollLast();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
