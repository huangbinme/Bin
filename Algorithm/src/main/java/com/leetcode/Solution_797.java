package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(graph, ans, list, 0, graph.length);
        return ans;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> list, int cur, int target) {
        if (cur == target) {
            list.add(cur);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            list.add(cur);
            dfs(graph, ans, list, graph[cur][i], target);
            list.remove(list.size() - 1);
        }
    }
}
