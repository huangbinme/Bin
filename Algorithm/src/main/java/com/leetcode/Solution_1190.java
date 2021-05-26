package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_1190 {
    public String reverseParentheses(String s) {
        List<int[]> bracketsIndex = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') deque.add(i);
            if (s.charAt(i) == ')') bracketsIndex.add(new int[]{deque.pollLast(), i});
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int[] ints : bracketsIndex) {
            reverse(ints, stringBuilder);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (c != '(' && c != ')') ans.append(c);
        }
        return ans.toString();
    }

    private void reverse(int[] ints, StringBuilder sb) {
        int l = ints[0], r = ints[1];
        while (l < r) {
            char rC = sb.charAt(r);
            char lC = sb.charAt(l);
            sb.setCharAt(r--, lC);
            sb.setCharAt(l++, rC);
        }
    }
}
