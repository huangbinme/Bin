package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2007 {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        Arrays.sort(changed);
        int[] ans = new int[changed.length / 2];
        int ansIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            map.merge(changed[i], 1, Integer::sum);
        }
        for (int i = 0; i < changed.length; i++) {
            if (map.get(changed[i]) == 0) continue;
            int j = map.getOrDefault(changed[i] * 2, -1);
            if (j == 0 || j == -1) return new int[0];
            ans[ansIndex++] = changed[i];
            map.merge(changed[i], -1, Integer::sum);
            map.merge(changed[i] * 2, -1, Integer::sum);
        }
        return ans;
    }
}
