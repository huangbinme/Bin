package com.leetcode;

public class Solution_125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!validate(s.charAt(left))) {
                left++;
                continue;
            }
            if (!validate(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean validate(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
