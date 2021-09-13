package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_678 {
    public boolean checkValidString(String s) {
        Deque<Integer> blank = new LinkedList<>();
        Deque<Integer> left = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                blank.offerLast(i);
            } else if (s.charAt(i) == '(') {
                left.offerLast(i);
            } else {
                if (!left.isEmpty()) {
                    left.pollLast();
                } else {
                    if (blank.isEmpty()) {
                        return false;
                    } else {
                        blank.pollFirst();
                    }
                }
            }
        }
        while (!left.isEmpty() && !blank.isEmpty() && blank.peekLast() > left.peekLast()) {
            blank.pollLast();
            left.pollLast();
        }
        return left.isEmpty();
    }
}
