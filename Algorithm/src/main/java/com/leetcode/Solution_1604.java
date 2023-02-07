package com.leetcode;

import java.util.*;

public class Solution_1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> list = map.computeIfAbsent(keyName[i], k -> new ArrayList<>());
            String time = keyTime[i];
            int split = keyTime[i].indexOf(':');
            list.add(Integer.parseInt(time.substring(0, split)) * 60 + Integer.parseInt(time.substring(split + 1)));
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            for (int i = 0; i < list.size() - 2; i++) {
                Integer cur = list.get(i);
                Integer next = list.get(i + 2);
                if (next - cur <= 60) {
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
