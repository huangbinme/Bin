package com.leetcode;

import java.util.*;

public class Solution_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Point>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<Point> list = graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>());
            list.add(new Point(edges[i][1], succProb[i]));
            List<Point> list2 = graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>());
            list2.add(new Point(edges[i][0], succProb[i]));
        }
        boolean[] note = new boolean[n];
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(p -> p.succProd * -1));
        queue.offer(new Point(start, 1));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (note[point.p]) continue;
            note[point.p] = true;
            if (point.p == end) return point.succProd;
            List<Point> points = graph.getOrDefault(point.p, new ArrayList<>());
            for (int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                queue.offer(new Point(p.p, p.succProd * point.succProd));
            }
        }
        return 0;
    }

    public class Point {
        int p;
        double succProd;

        public Point(int p, double succProd) {
            this.p = p;
            this.succProd = succProd;
        }
    }
}
