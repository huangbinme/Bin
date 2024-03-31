package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_331 {
    public boolean isValidSerialization(String preorder) {
        Deque<String> deque = new LinkedList<>();
        String[] strings = preorder.split(",");
        for (int i = 0; i < strings.length; i++) {
            String in = strings[i];
            if (deque.isEmpty() || !in.equals("#") || !deque.peekLast().equals("#")) {
                deque.offerLast(in);
            } else {
                // 弹出符合要求的元素
                while (deque.size() >= 2) {
                    String last = deque.pollLast(), sec = deque.pollLast();
                    if (!(last.equals("#") && !sec.equals("#"))) {
                        deque.offerLast(sec);
                        deque.offerLast(last);
                        break;
                    }
                }
                deque.offerLast(in);
            }
        }
        return deque.size() == 1 && deque.peekLast().equals("#");
    }
}

