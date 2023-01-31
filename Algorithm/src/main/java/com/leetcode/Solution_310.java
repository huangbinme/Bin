package com.leetcode;

import java.util.*;

public class Solution_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return Arrays.asList(0);
        List<List<Integer>> graph = toGraph(n, edges);
        Deque<Integer> deque = new LinkedList<>();
        int[] note = new int[n];
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                deque.offerLast(i);
            } else {
                note[i] = graph.get(i).size();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer poll = deque.pollFirst();
                List<Integer> list = graph.get(poll);
                for (Integer integer : list) {
                    note[integer]--;
                    if (note[integer] == 1) {
                        deque.offerLast(integer);
                    }
                }
                ans.add(poll);
            }
        }
        return ans;
    }

    private List<List<Integer>> toGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
