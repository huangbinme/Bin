package com.leetcode;

import java.util.*;

public class Solution_3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(points[i][0]);
        }
        if (w == 0) return set.size();
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        int ans = 0;
        int index = 0;
        while (index < list.size()) {
            ans++;
            int i = list.get(index);
            int j = i + w;
            int k = index;
            while (k < list.size() && list.get(k) <= j) k++;
            index = k;
        }
        return ans;
    }
}
