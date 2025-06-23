package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_409 {
    public int longestPalindrome(String s) {
        int plusOne = 0, ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            ans += (entry.getValue() / 2) * 2;
            if (entry.getValue() % 2 != 0) plusOne = 1;
        }
        return ans + plusOne;
    }
}