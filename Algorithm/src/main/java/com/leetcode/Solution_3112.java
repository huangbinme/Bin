package com.leetcode;

import java.util.*;

public class Solution_3112 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<int[]> list1 = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list1.add(new int[]{edges[i][1], edges[i][2]});
            List<int[]> list2 = graph.getOrDefault(edges[i][1], new ArrayList<>());
            list2.add(new int[]{edges[i][0], edges[i][2]});
            graph.put(edges[i][0], list1);
            graph.put(edges[i][1], list2);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> deque = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        deque.offer(new int[]{0, 0});
        boolean[] visit = new boolean[n];
        while (!deque.isEmpty()) {
            int[] p = deque.poll();
            int node = p[0], time = p[1];
            if(visit[node]) continue;
            if (time < disappear[node]) {
                ans[node] = ans[node] == -1 ? time : Math.min(ans[node], time);
                visit[node] = true;
                List<int[]> subs = graph.get(node);
                if (subs != null) {
                    for (int[] sub : subs) {
                        if (!visit[sub[0]]) {
                            int[] ints = new int[]{sub[0], time + sub[1]};
                            deque.offer(ints);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
