package com.solutions;

import java.util.HashSet;
import java.util.Set;

public class Solution_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            if (set.size() == 2 && !set.contains(s.charAt(r))) {
                int find_left = r - 2;
                while (s.charAt(find_left) == s.charAt(find_left + 1)) find_left--;
                l = find_left + 1;
                set.clear();
                set.add(s.charAt(l));
            }
            set.add(s.charAt(r++));
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
