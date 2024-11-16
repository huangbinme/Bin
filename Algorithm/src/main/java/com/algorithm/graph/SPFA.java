package com.algorithm.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class SPFA {
    /**
     * 问题：有n个节点，编号从0到n-1，求从k点出发，求到其他任意点的最短距离
     *
     * @param graph : 邻接表，key为node，value为二级map，二级map的key是相邻节点，value是到相邻节点的距离
     * @param k     ：起点
     * @return int[] : k点到其余点的最短距离结果
     */
    public int[] getShortestDistance(Map<Integer, Map<Integer, Integer>> graph, int n, int k) {
        int infinity = Integer.MAX_VALUE / 2;
        int[] ans = new int[n];
        Arrays.fill(ans, infinity);
        ans[k] = 0;
        Deque<Integer> deque = new LinkedList<>();
        boolean[] inQueue = new boolean[n];//用数组记录节点是否在deque中
        deque.offer(k);
        inQueue[k] = true;
        while (!deque.isEmpty()) {
            int node = deque.pollFirst();
            inQueue[node] = false;
            Map<Integer, Integer> child = graph.get(node);
            if (child != null) {
                for (Map.Entry<Integer, Integer> entry : child.entrySet()) {
                    int nextNode = entry.getKey(), dis = entry.getValue();
                    if (ans[node] != infinity && ans[nextNode] > ans[node] + dis) {//dis的值将要被改变
                        ans[nextNode] = ans[node] + dis;//改变dis的值
                        if (!inQueue[nextNode]) {//入队前先判断是否在队列中
                            deque.offerLast(nextNode);
                            inQueue[nextNode] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
