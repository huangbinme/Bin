package com.leetcode;

import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            graph.computeIfAbsent(times[i][0], key -> new HashMap<>()).put(times[i][1], times[i][2]);
        }
        int[] minDis = new int[n + 1];
        int infinity = Integer.MAX_VALUE / 2;
        boolean[] isLoop = new boolean[n + 1];
        Arrays.fill(minDis, infinity);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0], dis = poll[1];
            if (isLoop[node]) continue;
            isLoop[node] = true;
            minDis[node] = dis;
            Map<Integer, Integer> child = graph.get(node);
            if (child != null) {
                for (Map.Entry<Integer, Integer> entry : child.entrySet()) {
                    int childNode = entry.getKey(), childDis = entry.getValue();
                    if (!isLoop[childNode]) queue.offer(new int[]{childNode, childDis + dis});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < minDis.length; i++) {
            if (minDis[i] == infinity) return -1;
            ans = Math.max(ans, minDis[i]);
        }
        return ans;
    }
}
