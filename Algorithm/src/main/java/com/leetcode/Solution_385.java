package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_385 {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        return deserialize(s, 0, s.length());
    }

    private NestedInteger deserialize(String s, int start, int end) {
        if (s.charAt(start) != '[') {
            NestedInteger nestedInteger = new NestedInteger();
            nestedInteger.add(new NestedInteger(Integer.parseInt(s.substring(start, end))));
            return nestedInteger;
        }
        Deque<Integer> deque = new LinkedList<>();
        int p = start + 1;
        while (!(s.charAt(p) == ',' || s.charAt(p) == ']')) p++;
        NestedInteger nestedInteger = new NestedInteger();
        nestedInteger.add(new NestedInteger(Integer.parseInt(s.substring(start + 1, p))));
        p++;
        for (int i = p; i < end - 1; i++) {
            if (s.charAt(i) == '[') {
                deque.offerLast(i);
            } else if (s.charAt(i) == ']') {
                int l = deque.pollLast();
                if (deque.isEmpty()) {
                    nestedInteger.add(deserialize(s, l, i + 1));
                }
            }
        }
        return nestedInteger;
    }
}
