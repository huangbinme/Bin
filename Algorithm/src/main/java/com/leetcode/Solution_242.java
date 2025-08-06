package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            count[j]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int j = t.charAt(i) - 'a';
            count[j]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
            map.merge(t.charAt(i), -1, Integer::sum);
        }
        for (Integer value : map.values()) {
            if (!value.equals(0)) return false;
        }
        return true;
    }
}
