package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1081 {
    public String smallestSubsequence(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int[] inDeque = new int[26];
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inDeque[c - 'a'] == 1) {
                charCount[c - 'a']--;
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() > c && charCount[deque.peekLast() - 'a'] >= 1) {
                char poll = deque.pollLast();
                inDeque[poll - 'a']--;
            }
            deque.offerLast(c);
            inDeque[c - 'a']++;
            charCount[c - 'a']--;
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append(deque.pollFirst());
        }
        return ans.toString();
    }
}
