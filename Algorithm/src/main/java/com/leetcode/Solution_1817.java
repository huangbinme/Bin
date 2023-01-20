package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            map.computeIfAbsent(logs[i][0], key -> new HashSet<>()).add(logs[i][1]);
        }
        for (Set<Integer> set : map.values()) {
            ans[set.size() - 1]++;
        }
        return ans;
    }
}
