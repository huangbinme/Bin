package com.leetcode;

public class Solution_5740 {

    public int longestBeautifulSubstring(String word) {
        if (word == null || word.length() < 5) return 0;
        int ans = 0;
        int type = 1;
        int start = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) > word.charAt(i - 1)) type++;
            if (word.charAt(i) < word.charAt(i - 1)) {
                start = i;
                type = 1;
            }
            if (type == 5) ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
