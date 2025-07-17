package com.review;

public class Solution_151 {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int p = 0;
        while (p < s.length()) {
            while (p < s.length() && s.charAt(p) == ' ') p++;
            if (p < s.length()) {
                int l = p, r = p;
                while (r < s.length() && s.charAt(r) != ' ') r++;
                ans.insert(0, s.substring(l, r) + " ");
                p = r;
            } else {
                break;
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
