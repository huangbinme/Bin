package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution_48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)));
            }
            map.put(s.charAt(r), ++r);
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
