package com.review;

import java.util.HashMap;
import java.util.Map;

public class Solution_76 {
    public String minWindow(String s, String t) {
        String ans = "";
        Map<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }
        int l = 0, r = 0;
        while (r <= s.length()) {
            while (cover(sMap, tMap)) {
                if ("".equals(ans) || ans.length() > r - l) {
                    ans = s.substring(l, r);
                }
                if (tMap.containsKey(s.charAt(l))) sMap.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            if (r == s.length()) break;
            if (tMap.containsKey(s.charAt(r))) sMap.merge(s.charAt(r), 1, Integer::sum);
            r++;
        }
        return ans;
    }

    private boolean cover(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (sMap.size() < tMap.size()) return false;
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char c = entry.getKey();
            int fre = entry.getValue();
            if (fre < tMap.get(c)) return false;
        }
        return true;
    }
}