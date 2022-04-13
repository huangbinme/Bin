package com.leetcode.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution_50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) return entry.getKey();
        }
        return ' ';
    }
}
