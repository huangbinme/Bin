package com.review;

import java.util.*;

public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] in = new int[numCourses];
        addEdges(graph, prerequisites, in);
        int finishedCount = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                deque.offerLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            finishedCount += size;
            for (int i = 0; i < size; i++) {
                int cur = deque.pollFirst();
                List<Integer> subs = graph.get(cur);
                if (subs != null) {
                    for (Integer sub : subs) {
                        in[sub]--;
                        if (in[sub] == 0) deque.offerLast(sub);
                    }
                }
            }
        }
        return finishedCount == numCourses;
    }

    private void addEdges(Map<Integer, List<Integer>> graph, int[][] prerequisites, int[] inAndOut) {
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            inAndOut[pre[0]]++;
            graph.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
        }
    }
}
