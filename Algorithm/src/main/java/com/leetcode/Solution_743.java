package com.leetcode;

import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int infinity = Integer.MAX_VALUE / 2;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            List<int[]> list = graph.computeIfAbsent(times[i][0], key -> new ArrayList<>());
            list.add(new int[]{times[i][1], times[i][2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] minDis = new int[n + 1];
        boolean[] loop = new boolean[n + 1];
        Arrays.fill(minDis, infinity);
        queue.offer(new int[]{k, infinity});
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int p = ints[0], dis = ints[1];
            if (loop[p]) continue;
            minDis[p] = dis;
            loop[p] = true;
            List<int[]> list = graph.get(p);
            if (list != null) {
                List<int[]> child = graph.get(p);
                for (int[] c : child) {
                    queue.offer(new int[]{c[0], c[1] + (dis == infinity ? 0 : dis)});
                }
            }
        }
        int ans = -1, loopCount = 0;
        for (int i = 1; i < minDis.length; i++) {
            if (loop[i]) loopCount++;
            if (minDis[i] != infinity) ans = Math.max(ans, minDis[i]);
        }
        return loopCount == n ? ans : -1;
    }
}
