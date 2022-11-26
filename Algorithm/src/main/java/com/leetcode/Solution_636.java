package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<String[]> deque = new LinkedList<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            if (split[1].equals("start")) {
                deque.offerLast(split);
            } else {
                String[] dequeStr = deque.pollLast();
                int appId = Integer.parseInt(dequeStr[0]);
                int runtime = Integer.parseInt(split[2]) - Integer.parseInt(dequeStr[2]) + 1;
                ans[appId] += runtime;
                if (!deque.isEmpty()) {
                    ans[Integer.parseInt(deque.peekLast()[0])] -= runtime;
                }
            }
        }
        return ans;
    }
}
