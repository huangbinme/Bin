package com.leetcode;

public class Solution_551 {
    public boolean checkRecord(String s) {
        int aCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') aCount++;
            if ((i < s.length() - 2 && s.charAt(i) == 'L' && s.charAt(i + 2) == 'L' && s.charAt(i + 1) == 'L') || aCount >= 2)
                return false;
        }
        return true;
    }
}
