package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char cur = 'a';
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ' || map.containsKey(c)) continue;
            map.put(c, cur);
            cur = (char) (cur + 1);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            ans.append(message.charAt(i) == ' ' ? ' ' : map.get(message.charAt(i)));
        }
        return ans.toString();
    }
}
