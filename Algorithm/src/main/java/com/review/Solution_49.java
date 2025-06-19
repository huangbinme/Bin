package com.review;

import java.util.*;

public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            byte[] bytes = s.getBytes();
            Arrays.sort(bytes);
            String key = new String(bytes);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            for (Integer i : entry.getValue()) {
                list.add(strs[i]);
            }
            ans.add(list);
        }
        return ans;
    }
}
