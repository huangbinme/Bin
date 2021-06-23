package com.leetcode;

public class Solution_921 {
    public int minAddToMakeValid(String s) {
        int lCount = 0, rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lCount++;
            } else {
                if (lCount > 0) {
                    lCount--;
                } else {
                    rCount++;
                }
            }
        }
        return lCount + rCount;
    }
}
