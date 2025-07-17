package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_394 {
    public String decodeString(String s) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Character> deque2 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                int l = s.indexOf('[', i);
                deque1.offerLast(Integer.valueOf(s.substring(i, l)));
                i = l - 1;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (deque2.peekLast() != '[') sb.insert(0, deque2.pollLast());
                deque2.pollLast();
                int repeat = deque1.pollLast();
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    sb2.append(sb);
                }
                for (int j = 0; j < sb2.length(); j++) {
                    deque2.offerLast(sb2.charAt(j));
                }
            } else {
                deque2.offerLast(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!deque2.isEmpty()) ans.append(deque2.pollFirst());
        return ans.toString();
    }
}
