package com.leetcode;

public class Solution_66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            } else {
                break;
            }
        }
        if (digits[0] == 10) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            digits[0] = 0;
            for (int i = 0; i < digits.length; i++) {
                ans[i + 1] = digits[i];
            }
            return ans;
        } else {
            return digits;
        }
    }
}
