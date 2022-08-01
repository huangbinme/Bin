package com.leetcode;

public class Solution_1374 {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return sb.append("b").toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return sb.toString();
        }
    }
}
