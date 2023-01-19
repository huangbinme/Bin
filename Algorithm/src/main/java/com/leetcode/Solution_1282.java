package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<List<Integer>> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            if (!list.isEmpty() && list.get(list.size() - 1).size() < groupSizes[i]) {
                list.get(list.size() - 1).add(i);
            } else {
                List<Integer> sub = new ArrayList<>();
                sub.add(i);
                list.add(sub);
            }
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<List<Integer>> value : map.values()) {
            ans.addAll(value);
        }
        return ans;
    }
}
