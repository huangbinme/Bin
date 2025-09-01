package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_224 {
    public int calculate(String s) {
        int ans = 0, sign = 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int curNum = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    curNum = curNum * 10 + (s.charAt(i) - '0');
                }
                ans += curNum * sign;
                sign = 1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                deque.offerLast(ans);
                deque.offerLast(sign);
                ans = 0;
                sign = 1;
            } else if (c == ')') {
                int signInDeque = deque.pollLast(), numInDeque = deque.pollLast();
                ans = ans * sign * signInDeque + numInDeque;
                sign = 1;
            }
        }
        return ans;
    }
}
