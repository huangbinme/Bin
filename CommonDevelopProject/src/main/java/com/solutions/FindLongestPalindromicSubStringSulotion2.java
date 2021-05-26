package com.solutions;

public class FindLongestPalindromicSubStringSulotion2 {
    private String result = "";

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            checkPalindromic(s, i, i);
            checkPalindromic(s, i, i + 1);
        }
        return result;
    }

    public void checkPalindromic(String str, int low, int high) {
        while (low >= 0 && high < str.length()) {
            if (str.charAt(low) == str.charAt(high)) {
                result = result.length() < high + 1 - low ? str.substring(low, high + 1) : result;
                low--;
                high++;
            } else {
                return;
            }
        }
    }
}
