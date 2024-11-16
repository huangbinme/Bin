package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    /**
     * 问题：有n个节点，编号从0到n-1，求从k点出发，求到其他任意点的最短距离
     *
     * @param graph : 邻接表，key为node，value为二级map，二级map的key是相邻节点，value是到相邻节点的距离
     * @param k     ：起点
     * @return int[] : k点到其余点的最短距离结果
     */
    public int[] getShortestDistance(Map<Integer, Map<Integer, Integer>> graph, int n, int k) {
        int infinity = Integer.MAX_VALUE / 2;
        List<int[]> edges = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : graph.entrySet()) {
            for (Map.Entry<Integer, Integer> valueEntry : entry.getValue().entrySet()) {
                edges.add(new int[]{entry.getKey(), valueEntry.getKey()});
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, infinity);
        ans[k] = 0;
        for (int i = 0; i < n - 1; i++) {//进行松弛操作，操作次数是总节点数量减1
            for (int[] edge : edges) {
                int p1 = edge[0], p2 = edge[1], dis = graph.get(p1).get(p2);
                if (ans[p1] != infinity) {
                    ans[p2] = Math.min(ans[p2], dis + ans[p1]);
                }
            }
        }
        return ans;
    }
}
