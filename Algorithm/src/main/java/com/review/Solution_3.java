package com.review;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r++));
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
