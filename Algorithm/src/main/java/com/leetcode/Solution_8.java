package com.leetcode;

public class Solution_8 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int type = 1, index = 0, ans = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index++;
            type = s.charAt(0) == '-' ? -1 : 1;
        }
        while (index < s.length()) {
            if (!Character.isDigit(s.charAt(index))) break;
            int cNum = s.charAt(index++) - '0';
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && cNum > (type == 1 ? 7 : 8)))
                return type == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + cNum;
        }
        return ans * type;
    }
}
