package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r++));
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
