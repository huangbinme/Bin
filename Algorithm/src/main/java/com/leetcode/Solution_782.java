package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_782 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % (entry.getKey() + 1) == 0) {
                ans += entry.getValue() / (entry.getKey() + 1) * (entry.getKey() + 1);
            } else {
                ans += (entry.getValue() / (entry.getKey() + 1) + 1) * (entry.getKey() + 1);
            }
        }
        return ans;
    }
}
