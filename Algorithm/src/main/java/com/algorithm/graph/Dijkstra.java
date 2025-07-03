package com.algorithm.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {


    /**
     * 问题：有n个节点，编号从0到n-1，求从k点出发，求到其他任意点的最短距离
     *
     * @param graph : 邻接表，key为node，value为二级map，二级map的key是相邻节点，value是到相邻节点的距离
     * @param k     ：起点
     * @return int[] : k点到其余点的最短距离结果
     */
    public int[] getShortestDistance(Map<Integer, Map<Integer, Integer>> graph, int n, int k) {
        int infinity = Integer.MAX_VALUE / 2; //假设距离无穷大
        int[] ans = new int[n];
        Arrays.fill(ans, infinity);
        boolean[] loop = new boolean[n]; //防止重复遍历
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));//int[1]代表从起点[k]到点int[0]的距离
        queue.offer(new int[]{k, 0});
        ans[k] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int p = poll[0], dis = poll[1];
            if (loop[p]) continue; //跳过遍历过的节点
            ans[p] = dis; //填入最短距离结果
            loop[p] = true;
            Map<Integer, Integer> child = graph.get(p);
            if (child != null) {
                for (Map.Entry<Integer, Integer> entry : child.entrySet()) {
                    if (!loop[entry.getKey()]) { //已经得到最短路径结果的子节点无需再次加入queue中
                        //dis + entry.getValue() : dis是从点k到父节点p的最短距离，entry的value是父节点到子节点的距离，所以要相加才代表从起点k到子节点的距离
                        queue.offer(new int[]{entry.getKey(), dis + entry.getValue()});
                    }
                }
            }
        }
        return ans;
    }

}
