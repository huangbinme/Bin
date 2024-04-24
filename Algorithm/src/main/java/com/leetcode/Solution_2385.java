package com.leetcode;

import java.util.*;

public class Solution_2385 {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(root, graph);
        int ans = -1;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(start);
        boolean[] visit = new boolean[100001];
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer j = deque.pollFirst();
                visit[j] = true;
                List<Integer> sub = graph.get(j);
                if (sub != null) {
                    for (Integer subNode : sub) {
                        if (!visit[subNode]) deque.offerLast(subNode);
                    }
                }
            }
            ans++;
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
