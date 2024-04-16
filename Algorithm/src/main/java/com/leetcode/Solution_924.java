package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_924 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        boolean[] visit = new boolean[graph.length];
        Set<Integer> set = new HashSet<>();
        for (int s = 0; s < initial.length; s++) {
            set.add(initial[s]);
        }
        int ans = -1, count = 0;
        for (int i = 0; i < initial.length; i++) {
            int[] c = dfs(graph, visit, set, initial[i]);
            if (c[0] == 1 && c[1] > count) {
                count = c[1];
                ans = initial[i];
            }
        }
        return ans == -1 ? initial[0] : ans;
    }

    private int[] dfs(int[][] graph, boolean[] visit, Set<Integer> initial, int start) {
        if (visit[start]) return new int[]{0, 0};
        int[] sub = graph[start];
        visit[start] = true;
        int[] ans = new int[2];
        ans[0] = initial.contains(start) ? 1 : 0;
        ans[1] = 1;
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] == 0 || i == start || visit[i]) continue;
            int[] subC = dfs(graph, visit, initial, i);
            ans[0] += subC[0];
            ans[1] += subC[1];
        }
        return ans;
    }
}
