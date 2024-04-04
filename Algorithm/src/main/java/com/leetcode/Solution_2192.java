package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = toMap(edges, n);
        List<Set<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new HashSet<>());
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Set<Integer> set = ans.get(entry.getKey());
            fillSet(set, entry.getKey(), map);
        }
        return convert(ans);
    }

    private void fillSet(Set<Integer> set, Integer key, Map<Integer, List<Integer>> map) {
        if(map.get(key).isEmpty()) return;
        List<Integer> list = map.get(key);
        for (int i = 0; i < list.size(); i++) {
            if(!set.contains(list.get(i))){
                set.add(list.get(i));
                fillSet(set, list.get(i), map);
            }
        }
    }

    private List<List<Integer>> convert(List<Set<Integer>> ans) {
        return ans.stream()
                .map(set -> new ArrayList<>(set))
                .peek(Collections::sort)
                .collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> toMap(int[][] edges, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}
