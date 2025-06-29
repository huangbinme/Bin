package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].isEmpty() || split[i].equals(".")) continue;
            if (split[i].equals("..")) {
                if (!deque.isEmpty()) deque.pollLast();
            } else {
                deque.offerLast(split[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append("/").append(deque.pollFirst());
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
