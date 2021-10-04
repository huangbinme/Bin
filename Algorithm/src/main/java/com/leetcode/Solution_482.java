package com.leetcode;

public class Solution_482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            count++;
            sb.insert(0, s.charAt(i));
            if (count == k) {
                count = 0;
                sb.append('-');
            }
        }
        if (sb.length() != 0 && sb.charAt(0) == '-') sb.deleteCharAt(0);
        return sb.reverse().toString().toUpperCase();
    }
}
