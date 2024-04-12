package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1766 {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);

            List<Integer> list2 = graph.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            graph.put(edge[1], list2);
        }
        Map<Integer, int[]> ancestor = new HashMap<>();
        int[] ans = new int[nums.length];
        dfs(nums, 0, graph, ans, ancestor, 0, -1);
        return ans;
    }

    private void dfs(int[] nums, int curIndex, Map<Integer, List<Integer>> graph, int[] ans, Map<Integer, int[]> ancestor, int depth, int parent) {
        int curNum = nums[curIndex];
        int distance = Integer.MAX_VALUE, id = -1;
        for (Map.Entry<Integer, int[]> entry : ancestor.entrySet()) {
            if (depth - entry.getValue()[0] > 0 && depth - entry.getValue()[0] < distance && gcd(entry.getKey(), curNum) == 1) {
                distance = depth - entry.getValue()[0];
                id = entry.getValue()[1];
            }
        }
        ans[curIndex] = id;

        List<Integer> sub = graph.get(curIndex);
        int[] ints = ancestor.get(curNum);
        ancestor.put(curNum, new int[]{depth, curIndex});
        for (int i = 0; sub != null && i < sub.size(); i++) {
            if (sub.get(i) == parent) continue;
            dfs(nums, sub.get(i), graph, ans, ancestor, depth + 1, curIndex);
        }
        ancestor.remove(curNum);
        if (ints != null) ancestor.put(curNum, ints);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
