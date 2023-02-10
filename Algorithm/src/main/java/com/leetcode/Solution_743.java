package com.leetcode;

import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            List<int[]> ints = graph.computeIfAbsent(time[0], v -> new ArrayList<>());
            ints.add(new int[]{time[1], time[2]});
        }
        boolean[] note = new boolean[n];
        int[] minDis = new int[n];
        Arrays.fill(minDis, Integer.MAX_VALUE / 2);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        queue.offer(new int[]{k, 0});
        int ans = 0, loopCount = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int p = poll[0], dis = poll[1];
            if (note[p - 1]) continue;
            note[p - 1] = true;
            loopCount++;
            ans = Math.max(ans, dis);
            minDis[p - 1] = dis;
            List<int[]> child = graph.getOrDefault(p, new ArrayList<>());
            for (int i = 0; i < child.size(); i++) {
                int[] childP = child.get(i);
                if (minDis[childP[0] - 1] > dis + childP[1]) {
                    minDis[childP[0] - 1] = dis + childP[1];
                    queue.offer(new int[]{childP[0], dis + childP[1]});
                }
            }
        }
        return loopCount == n ? ans : -1;
    }
}
