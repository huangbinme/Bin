package com.leetcode;

public class Solution_2114 {
    public int mostWordsFound(String[] sentences) {
        int ans = -1;
        for (int i = 0; i < sentences.length; i++) {
            ans = Math.max(ans, sentences[i].split(" ").length);
        }
        return ans;
    }
}
