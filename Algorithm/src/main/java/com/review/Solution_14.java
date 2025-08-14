package com.review;

public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            ans = getCommonPre(ans, strs[i]);
        }
        return ans;
    }

    public String getCommonPre(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return "";
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.length() <= s2.length() ? s1 : s2;
    }
}
