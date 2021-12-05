package com.leetcode;

import java.util.Arrays;

public class Solution_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] ints = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                ints[index]++;
                if (ints[index] > 1) return true;
            }
            return false;
        }
        int[] ints1 = new int[2], ints2 = new int[2];
        Arrays.fill(ints1, -1);
        Arrays.fill(ints2, -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (ints1[0] == -1) {
                    ints1[0] = s.charAt(i) - 'a';
                    ints2[0] = goal.charAt(i) - 'a';
                } else if (ints1[1] == -1) {
                    ints1[1] = s.charAt(i) - 'a';
                    ints2[1] = goal.charAt(i) - 'a';
                } else {
                    return false;
                }
            }
        }
        return ints1[1] != -1 && ints1[0] == ints2[1] && ints1[1] == ints2[0];
    }
}
