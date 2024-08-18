package com.leetcode;

public class Solution_551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') countA++;
        }
        return countA < 2 && !s.contains("LLL");
    }
}
