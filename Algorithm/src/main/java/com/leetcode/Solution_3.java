package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = 1;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.get(s.charAt(r)) > 1) {
                int count = map.get(s.charAt(l));
                if (count > 1) {
                    map.put(s.charAt(l), count - 1);
                } else {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            r++;
            ans = Math.max(ans, map.size());
        }
        return ans;
    }
}
