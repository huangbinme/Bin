package com.leetcode;

import java.math.BigDecimal;

public class Solution_306 {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    private boolean dfs(String num, int index, int count, BigDecimal one, BigDecimal two) {
        if (index >= num.length()) {
            return count > 2;
        }
        for (int i = index; i < num.length(); i++) {
            String substring = num.substring(index, i + 1);
            if (substring.length() > 1 && substring.charAt(0) == '0') return false;
            BigDecimal cur = new BigDecimal(substring);
            if (count >= 2) {
                int re = cur.compareTo(one.add(two));
                if (re > 0) {
                    return false;
                } else if (re < 0) {
                    continue;
                }
            }
            if (dfs(num, i + 1, count + 1, two, cur)) {
                return true;
            }
        }
        return false;
    }
}
