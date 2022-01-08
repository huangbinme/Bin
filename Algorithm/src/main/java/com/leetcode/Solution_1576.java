package com.leetcode;

public class Solution_1576 {
    public String modifyString(String s) {
        int l = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                for (char c = 'a'; c - 'a' < 26; c++) {
                    if ((i > 0 && c == chars[i - 1]) || (i < l - 1 && c == chars[i + 1])) continue;
                    chars[i] = c;
                    break;
                }
            }
        }
        return new String(chars);
    }
}
