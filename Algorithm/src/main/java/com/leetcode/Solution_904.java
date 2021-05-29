package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_904 {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0, l = 0, ans = 0;
        while (r < tree.length) {
            if (map.size() == 2 && !map.containsKey(tree[r])) {
                while (map.size() != 1) {
                    int value = map.get(tree[l]);
                    if (value == 1) {
                        map.remove(tree[l]);
                    } else {
                        map.put(tree[l], value - 1);
                    }
                    l++;
                }
            }
            map.put(tree[r], map.getOrDefault(tree[r++], 0) + 1);
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
