package com.algorithm.graph;

import java.util.Map;
import java.util.Optional;

public class Floyd {
    /**
     * 问题：有n个节点，编号从0到n-1，求从任意点出发，求到其他任意点的最短距离
     *
     * @param graph : 邻接表，key为node，value为二级map，二级map的key是相邻节点，value是到相邻节点的距离
     * @return int[][] : int[i][j]表示i点到j点的最短距离
     */
    public int[][] getShortestDistance(Map<Integer, Map<Integer, Integer>> graph, int n) {
        int infinity = Integer.MAX_VALUE / 2;
        int[][] ans = new int[n][n];//ans[i][j]表示从i点到j点的距离
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int finalI = i, finalJ = j;
                    ans[i][j] = Optional.of(graph).map(g -> g.get(finalI)).map(g -> g.get(finalJ)).orElse(infinity);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            iterate(ans, i, infinity);//迭代次数为节点总数
        }
        return ans;
    }

    private void iterate(int[][] ans, int mid, int infinity) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                if (i != j && i != mid && j != mid) {//只需考虑mid中间节点不参与的情况
                    int newDis = (ans[i][mid] == infinity || ans[mid][j] == infinity) ? infinity : ans[i][mid] + ans[mid][j];
                    ans[i][j] = Math.min(ans[i][j], newDis);
                }
            }
        }
    }
}
