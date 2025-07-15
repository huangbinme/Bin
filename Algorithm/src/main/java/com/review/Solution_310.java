package com.review;

import java.util.*;

public class Solution_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return Arrays.asList(0);
        int[] edgesCount = new int[n];
        Map<Integer, List<Integer>> graph = toGraph(edges);
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            edgesCount[entry.getKey()] = entry.getValue().size();
            if(entry.getValue().size() == 1){
                edgesCount[entry.getKey()] = 0;
                list.add(entry.getKey());
            }
        }
        while (!list.isEmpty()) {
            ans = new ArrayList<>(list);
            List<Integer> nextList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Integer j = list.get(i);
                List<Integer> sub = graph.get(j);
                for (int k = 0; k < sub.size(); k++) {
                    if (edgesCount[sub.get(k)] == 2) {
                        nextList.add(sub.get(k));
                    }
                    edgesCount[sub.get(k)]--;
                }
            }
            list = nextList;
        }
        return ans;
    }

    private Map<Integer, List<Integer>> toGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        return graph;
    }
}
