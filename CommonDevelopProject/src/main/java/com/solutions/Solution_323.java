package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_323 {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        generateGraph(graph, edges);
        boolean[] booleans = new boolean[n];
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (booleans[i]) continue;
            count++;
            dfs(booleans, graph, i);
        }
        return count;
    }

    private void dfs(boolean[] booleans, List<Integer>[] graph, int index) {
        if (booleans[index]) return;
        booleans[index] = true;
        List<Integer> list = graph[index];
        for (int i = 0; i < list.size(); i++) {
            dfs(booleans, graph, list.get(i));
        }
    }

    private void generateGraph(List<Integer>[] graph, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
    }
}
