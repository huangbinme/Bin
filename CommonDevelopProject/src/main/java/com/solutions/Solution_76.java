package com.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> slidWin = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            add(tMap, t.charAt(i));
        }
        int l = 0, r = 0;
        String ans = "";
        while (r < s.length()) {
            add(slidWin, s.charAt(r));
            r++;
            while (judge(slidWin, tMap)) {
                if ("".equals(ans)) {
                    ans = s.substring(l, r);
                } else {
                    ans = ans.length() > r - l ? s.substring(l, r) : ans;
                }
                remove(slidWin, s.charAt(l));
                l++;
            }
        }
        return ans;
    }

    private boolean judge(Map<Character, Integer> slidWin, Map<Character, Integer> tMap) {
        if (slidWin.size() < tMap.size()) return false;
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!slidWin.containsKey(key) || slidWin.get(key) < value) return false;
        }
        return true;
    }

    private void add(Map<Character, Integer> map, char c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private void remove(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) return;
        Integer value = map.get(c);
        if (value == 1) {
            map.remove(c);
        } else {
            map.put(c, value - 1);
        }
    }
}
