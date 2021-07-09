package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1711 {
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007, max = 1 << 22;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 1; j < max; j = j << 1) {
                int find = j - deliciousness[i];
                int count = map.getOrDefault(find, 0);
                ans += count;
                ans %= mod;
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return ans;
    }
}
