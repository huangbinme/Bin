package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pToSmap = new HashMap<>();
        Set<String> valueSet = new HashSet<>();
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strings[i];
            String v = pToSmap.get(c);
            if (v != null && !v.equals(str)) return false;
            if (v == null) {
                if(valueSet.contains(str)) return false;
                pToSmap.put(c, str);
                valueSet.add(str);
            }
        }
        return true;
    }
}
