package com.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.naturalOrder());
        int pointCount = 1, ans = 0;
        for (int i = 1; i < points.length; i++) {
            queue.add(new Edge(points[0], points[i]));
        }
        Map<int[], Boolean> mark = new HashMap<>();
        mark.put(points[0], true);
        for (int i = 1; i < points.length; i++) {
            mark.put(points[i], false);
        }
        while (pointCount != points.length) {
            while (!queue.isEmpty() && mark.get(queue.peek().x) && mark.get(queue.peek().y)) queue.poll();
            if (queue.isEmpty()) break;
            Edge e = queue.poll();
            ans += e.weight;
            pointCount++;
            int[] p = mark.get(e.x) ? e.y : e.x;
            for (Map.Entry<int[], Boolean> entry : mark.entrySet()) {
                if (!equals(entry.getKey(), p) && !entry.getValue()) {
                    queue.add(new Edge(p, entry.getKey()));
                }
            }
            mark.put(p, true);
        }
        return ans;
    }

    private boolean equals(int[] x, int[] y) {
        return x[0] == y[0] && x[1] == y[1];
    }

    public static class Edge implements Comparable<Edge> {
        int[] x;
        int[] y;
        int weight;

        public Edge(int[] x, int[] y) {
            this.x = x;
            this.y = y;
            this.weight = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
