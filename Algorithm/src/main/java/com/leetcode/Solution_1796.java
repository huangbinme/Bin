package com.leetcode;

public class Solution_1796 {
    public int secondHighest(String s) {
        int n1 = -1, n2 = -1;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n >= 0 && n <= 9) {
                if (n > n1) {
                    n2 = n1;
                    n1 = n;
                } else if (n < n1 && n > n2) {
                    n2 = n;
                }
            }
        }
        return n2;
    }
}
