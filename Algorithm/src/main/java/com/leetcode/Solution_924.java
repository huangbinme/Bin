package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_924 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        boolean[] visit = new boolean[graph.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < initial.length; i++) {
            set.add(initial[i]);
        }
        int ans = initial[0], count = 0;
        for (int i = 0; i < initial.length; i++) {
            int[] subAns = dfs(graph, visit, set, initial[i]);
            if (subAns[0] == 1 && subAns[1] > count) {
                count = subAns[1];
                ans = initial[i];
            }
        }
        return ans;
    }

    private int[] dfs(int[][] graph, boolean[] visit, Set<Integer> initial, int curNode) {
        if (visit[curNode]) return new int[]{0, 0};
        int[] sub = graph[curNode];
        visit[curNode] = true;
        int[] ans = new int[2];
        ans[0] = initial.contains(curNode) ? 1 : 0;
        ans[1] = 1;
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] == 0 || i == curNode) continue;
            int[] subC = dfs(graph, visit, initial, i);
            ans[0] += subC[0];
            ans[1] += subC[1];
        }
        return ans;
    }
}
