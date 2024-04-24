package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2385 {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(root, graph);
        return dfs2(graph, start, -1);
    }

    private int dfs2(Map<Integer, List<Integer>> graph, int cur, int parent) {
        int ans = 0;
        List<Integer> subs = graph.getOrDefault(cur, new ArrayList<>());
        for (Integer sub : subs) {
            if(sub == parent) continue;
            ans = Math.max(ans, 1 + dfs2(graph, sub, cur));
        }
        return ans;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null) return;
        if (root.left != null) {
            add(root, root.left, graph);
        }
        if (root.right != null) {
            add(root, root.right, graph);
        }
        dfs(root.right, graph);
        dfs(root.left, graph);
    }

    private void add(TreeNode root, TreeNode sub, Map<Integer, List<Integer>> graph) {
        graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(sub.val);
        graph.computeIfAbsent(sub.val, k -> new ArrayList<>()).add(root.val);
    }
}
