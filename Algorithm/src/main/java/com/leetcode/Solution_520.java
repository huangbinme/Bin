package com.leetcode;

public class Solution_520 {
    public boolean detectCapitalUse(String word) {
        int lowerCount = 0, upperCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (upper(word.charAt(i))) {
                upperCount++;
            } else {
                lowerCount++;
            }
        }
        return lowerCount == word.length() || upperCount == word.length() || (word.length() > 1 && upper(word.charAt(0)) && lowerCount == word.length() - 1);
    }

    private boolean upper(char c) {
        return c - 'A' >= 0 && c - 'A' <= 25;
    }
}
