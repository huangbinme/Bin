package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < suits.length; i++) {
            set.add(suits[i]);
        }
        if (set.size() == 1) return "Flush";
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        if (max >= 3) return "Three of a Kind";
        if (max == 2) return "Pair";
        return "High Card";
    }
}
