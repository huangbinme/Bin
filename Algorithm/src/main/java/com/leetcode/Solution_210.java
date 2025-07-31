package com.leetcode;

import java.util.*;

public class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inCount = new int[numCourses];
        fillInCount(inCount, prerequisites);
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < inCount.length; i++) {
            if (inCount[i] == 0) {
                deque.offerLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer p = deque.pollFirst();
                ans.add(p);
                List<Integer> subs = graph.get(p);
                if (subs != null) {
                    for (Integer sub : subs) {
                        inCount[sub]--;
                        if (inCount[sub] == 0) {
                            deque.offerLast(sub);
                        }
                    }
                }
            }
        }
        return ans.size() == numCourses ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            List<Integer> sub = graph.computeIfAbsent(pre[1], v -> new ArrayList<>());
            sub.add(pre[0]);
        }
        return graph;
    }

    private void fillInCount(int[] inCount, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            inCount[prerequisites[i][0]]++;
        }
    }
}
