package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_684 {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            graph.get(edges[i][0]).remove(edges[i][1]);
            graph.get(edges[i][1]).remove(edges[i][0]);
            boolean reach = dfs(graph, new HashSet<>(), edges[i][0], edges[i][1]);
            if (reach) return edges[i];
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return new int[0];
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visit, int from, int to) {
        Set<Integer> set = graph.get(from);
        visit.add(from);
        for (Integer i : set) {
            if (i == to) return true;
            if (visit.contains(i)) continue;
            if (dfs(graph, visit, i, to)) return true;
        }
        return false;
    }
}