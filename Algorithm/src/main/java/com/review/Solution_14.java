package com.review;

public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        String base = strs[0];
        int ans = -1;
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            boolean match = true;
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || str.charAt(i) != c) {
                    match = false;
                    break;
                }
            }
            if (match) {
                ans++;
            } else {
                break;
            }
        }
        return ans == -1 ? "" : base.substring(0, ans + 1);
    }
}
