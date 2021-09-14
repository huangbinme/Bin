package com.leetcode;

import java.util.List;

public class Solution_524 {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length();
            } else {
                return s1.compareTo(s2);
            }
        });
        for (String str : dictionary) {
            if (check(s, str)) return str;
        }
        return "";
    }

    private boolean check(String base, String str) {
        int baseIndex = 0, strIndex = 0;
        while (baseIndex < base.length() && strIndex < str.length()) {
            if (base.charAt(baseIndex) == str.charAt(strIndex)) {
                baseIndex++;
                strIndex++;
            } else {
                baseIndex++;
            }
        }
        return strIndex >= str.length();
    }
}
