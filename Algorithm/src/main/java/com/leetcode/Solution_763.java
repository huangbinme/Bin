package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        initMap(map, s);
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0, max = 0;
        while (r < s.length()) {
            int dis = map.get(s.charAt(r));
            if (max == 0) max = dis;
            if (r == max) {
                ans.add(r - l + 1);
                l = ++r;
                max = 0;
                continue;
            }
            max = Math.max(max, dis);
            r++;
        }
        return ans;
    }

    private void initMap(Map<Character, Integer> map, String s) {
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
    }
}
