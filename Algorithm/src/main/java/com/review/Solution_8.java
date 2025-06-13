package com.review;

public class Solution_8 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0 || (s.charAt(0) != '+' && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0)))) return 0;
        boolean isPositive = s.charAt(0) != '-';
        int start = s.charAt(0) == '+' || s.charAt(0) == '-' ? 1 : 0;
        while (start < s.length() && !(s.charAt(start) - '0' > 0 && s.charAt(start) - '0' <= 9)) {
            if (!Character.isDigit(s.charAt(start))) return 0;
            start++;
        }
        if (start == s.length()) return 0;
        int ans = 0;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) || ans == Integer.MAX_VALUE || ans == Integer.MIN_VALUE) break;
            if (ans > Integer.MAX_VALUE / 10) return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (isPositive && ans == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7) return Integer.MAX_VALUE;
            if (!isPositive && ans == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 8) return Integer.MIN_VALUE;
            ans *= 10;
            ans += (s.charAt(i) - '0');
        }
        return isPositive ? ans : ans * -1;
    }
}
