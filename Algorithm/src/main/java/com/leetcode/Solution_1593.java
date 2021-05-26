package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_1593 {
    int max = 0;

    public int maxUniqueSplit(String s) {
        Set<String> stringSet = new HashSet<>();
        dfs(s, stringSet, 0);
        return max;
    }

    private void dfs(String s, Set<String> stringSet, int start) {
        if (start == s.length()) {
            max = Math.max(stringSet.size(), max);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String subStr = s.substring(start, i);
            if (stringSet.contains(subStr)) continue;
            stringSet.add(subStr);
            dfs(s, stringSet, i);
            stringSet.remove(subStr);
        }
    }
}
