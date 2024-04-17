package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < initial.length; i++) {
            set.add(initial[i]);
        }
        int c = 0, ans = initial[0];
        for (int i = 0; i < initial.length; i++) {
            int curNode = initial[i];
            boolean[] visit = new boolean[graph.length];
            visit[curNode] = true;
            int[] sub = graph[curNode];
            int subC = 0;
            for (int j = 0; j < sub.length; j++) {
                if (sub[j] == 0 || j == curNode) continue;
                int[] k = dfs(graph, set, visit, j);
                if (k[0] == 0) subC += k[1];
            }
            if (subC > c) {
                ans = initial[i];
                c = subC;
            }
        }
        return ans;
    }

    private int[] dfs(int[][] graph, Set<Integer> set, boolean[] visit, int curNode) {
        if (visit[curNode]) return new int[]{0, 0};
        int[] ans = new int[2];
        ans[0] = set.contains(curNode) ? 1 : 0;
        ans[1] = 1;
        int[] sub = graph[curNode];
        visit[curNode] = true;
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] == 0 || i == curNode) continue;
            int[] subAns = dfs(graph, set, visit, i);
            ans[0] += subAns[0];
            ans[1] += subAns[1];
        }
        return ans;
    }
}
