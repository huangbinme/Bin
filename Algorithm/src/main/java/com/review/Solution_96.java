package com.review;

import java.util.HashMap;
import java.util.Map;

public class Solution_96 {

    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        return dfs(1, n);
    }

    private int dfs(int min, int max) {
        if (min >= max) {
            return 1;
        }
        int ans = map.getOrDefault(max - min, 0);
        if(ans != 0) return ans;
        for (int i = min; i <= max; i++) {
            int l = dfs(min, i - 1);
            int r = dfs(i + 1, max);
            ans += (l * r);
        }
        map.put(max - min, ans);
        return ans;
    }
}
