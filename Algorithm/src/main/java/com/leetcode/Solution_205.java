package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sC = s.charAt(i), tC = t.charAt(i);
            if (map.containsKey(sC)) {
                char v = map.get(sC);
                if (v != tC) return false;
            } else {
                if(set.contains(tC)) return false;
                map.put(sC, tC);
                set.add(tC);
            }
        }
        return true;
    }
}
