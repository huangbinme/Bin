package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_447 {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) return 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int dis = getDistance(points[i], points[j]);
                if (map.containsKey(dis)) {
                    ans += map.get(dis) * 2;
                }
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            map.clear();
        }
        return ans;
    }

    public int getDistance(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
}
