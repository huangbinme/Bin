package com.leetcode;

import java.util.Arrays;

public class Solution_1079 {
    int max = 0;

    public int numTilePossibilities(String tiles) {
        String[] strings = tiles.split("");
        Arrays.sort(strings);
        boolean[] booleans = new boolean[strings.length];
        dfs(strings, booleans, 0);
        return max;
    }

    private void dfs(String[] strings, boolean[] booleans, int count) {
        if (count == strings.length) return;

        for (int i = 0; i < booleans.length; i++) {
            if (i > 0 && strings[i].equals(strings[i - 1]) && !booleans[i - 1]) continue;
            if (!booleans[i]) {
                max++;
                booleans[i] = true;
                dfs(strings, booleans, 1);
                booleans[i] = false;
            }
        }
    }
}
