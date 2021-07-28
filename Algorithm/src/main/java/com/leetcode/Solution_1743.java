package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            List<Integer> list1 = map.getOrDefault(adjacentPairs[i][0], new ArrayList<>());
            list1.add(adjacentPairs[i][1]);
            map.put(adjacentPairs[i][0], list1);
            List<Integer> list2 = map.getOrDefault(adjacentPairs[i][1], new ArrayList<>());
            list2.add(adjacentPairs[i][0]);
            map.put(adjacentPairs[i][1], list2);
        }
        int[] ans = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[0] = entry.getKey();
                break;
            }
        }
        for (int i = 0; i < ans.length - 1; i++) {
            List<Integer> list = map.get(ans[i]);
            int next = list.size() == 1 ? list.get(0) : (list.get(0) == ans[i - 1] ? list.get(1) : list.get(0));
            ans[i + 1] = next;
        }
        return ans;
    }
}
