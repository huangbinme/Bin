package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] chars = new int[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 2) return true;
            }
            return false;
        } else {
            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) diff.add(i);
            }
            if (diff.size() != 2) return false;
            if (s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0)))
                return true;
            return false;
        }
    }
}
