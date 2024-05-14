package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.merge(tasks[i], 1, Integer::sum);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int c = cal(entry.getValue());
            if (c == -1) return -1;
            ans += c;
        }
        return ans;
    }

    private int cal(int value) {
        int ans = -1;
        int maxX = value / 2;
        for (int i = 0; i <= maxX; i++) {
            int j = value - i * 2;
            if (j % 3 != 0) continue;
            int subAns = i + j / 3;
            ans = ans == -1 ? subAns : Math.min(ans, subAns);
        }
        return ans;
    }
}
