package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_678 {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>(), any = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.offerLast(i);
            } else if (c == '*') {
                any.offerLast(i);
            } else {
                if (left.size() > 0) {
                    left.pollLast();
                } else if (any.size() > 0) {
                    any.pollLast();
                } else {
                    return false;
                }
            }
        }
        while (left.size() > 0 && any.size() > 0) {
            int l1 = left.pollLast(), l2 = any.pollLast();
            if (l1 > l2) return false;
        }
        return left.isEmpty();
    }
}
