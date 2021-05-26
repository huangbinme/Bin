package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_13 {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.trim().equals("")) return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                result += map.get(s.charAt(i));
                break;
            }
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (lagerOrEquals(a, b)) {
                result += map.get(a);
            } else {
                result = result + map.get(b) - map.get(a);
                i++;
            }
        }
        return result;
    }

    public boolean lagerOrEquals(Character a, Character b) {
        return map.get(a) >= map.get(b);
    }
}
