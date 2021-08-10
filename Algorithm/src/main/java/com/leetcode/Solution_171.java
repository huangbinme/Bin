package com.leetcode;

public class Solution_171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0, carry = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            ans += (columnTitle.charAt(i) - 'A' + 1) * carry;
            carry *= 26;
        }
        return ans;
    }
}
