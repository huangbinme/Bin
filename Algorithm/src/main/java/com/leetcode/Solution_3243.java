package com.leetcode;

import java.util.*;

public class Solution_3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i + 1);
            graph.put(i, list);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            graph.get(queries[i][0]).add(queries[i][1]);
            ans[i] = getMinDis(graph, n - 1);
        }
        return ans;
    }

    private int getMinDis(Map<Integer, List<Integer>> graph, int end) {
        int[] minDis = new int[end + 1];
        Arrays.fill(minDis, -1);
        boolean[] visit = new boolean[end + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int p = poll[0], dis = poll[1];
            if (visit[p]) continue;
            minDis[p] = dis;
            visit[p] = true;
            List<Integer> child = graph.get(p);
            if (child != null) {
                for (Integer i : child) {
                    if (!visit[i]) {
                        queue.offer(new int[]{i, dis + 1});
                    }
                }
            }
        }
        return minDis[minDis.length - 1];
    }
}
