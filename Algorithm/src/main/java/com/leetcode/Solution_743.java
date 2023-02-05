package com.leetcode;

import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            List<List<Integer>> list = graph.computeIfAbsent(times[i][0], key -> new ArrayList<>());
            list.add(Arrays.asList(times[i][1], times[i][2]));
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.get(1)));
        queue.offer(Arrays.asList(k, 0));
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int point = poll.get(0), toCurDis = dis[point - 1];
            List<List<Integer>> childList = graph.get(point);
            for (int i = 0; childList != null && i < childList.size(); i++) {
                List<Integer> child = childList.get(i);
                if (toCurDis == Integer.MAX_VALUE || toCurDis + child.get(1) < dis[child.get(0) - 1]){
                    dis[child.get(0) - 1] = toCurDis + child.get(1);
                    queue.offer(child);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}
