package com.solutions;

public class Solution_28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.trim().equals("")) return 0;
        int check = haystack.length() - needle.length();
        if (check < 0) return -1;
        for (int i = 0; i <= check; i++) {
            if (predicate(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean predicate(String haystack, String needle, int index) {
        int cursor = index;
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.length() >= cursor && haystack.charAt(cursor) != needle.charAt(i)) {
                return false;
            }
            cursor++;
        }
        return true;
    }
}
