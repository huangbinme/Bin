package com.leetcode;

import java.util.*;

public class Solution_433 {

    public int minMutation(String start, String end, String[] bank) {
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bs = new HashSet<>(Arrays.asList(bank)), note = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        int ans = -1, cur = 0;
        deque.offerLast(start);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String s = deque.pollFirst();
                if (s.equals(end)) {
                    if (ans == -1) {
                        ans = cur;
                    } else {
                        ans = Math.min(ans, cur);
                    }
                }
                StringBuilder sb = new StringBuilder(s);
                for (int j = 0; j < sb.length(); j++) {
                    for (int k = 0; k < chars.length; k++) {
                        if (chars[k] == sb.charAt(j)) continue;
                        char pre = sb.charAt(j);
                        sb.setCharAt(j, chars[k]);
                        String subS = sb.toString();
                        if (bs.contains(subS) && !note.contains(subS)) {
                            note.add(subS);
                            deque.offerLast(subS);
                        }
                        sb.setCharAt(j, pre);
                    }
                }
            }
            cur++;
        }
        return ans;
    }
}
