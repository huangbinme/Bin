package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_2399 {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer pre = map.getOrDefault(s.charAt(i), -1);
            if (pre == -1) {
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i - pre - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (distance[entry.getKey() - 'a'] != entry.getValue()) return false;
        }
        return true;
    }
}
