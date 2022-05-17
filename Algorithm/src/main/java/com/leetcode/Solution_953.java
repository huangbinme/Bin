package com.leetcode;

public class Solution_953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ints = new int[26];
        for (int i = 0; i < order.length(); i++) {
            ints[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!smaller(ints, words[i], words[i + 1])) return false;
        }
        return true;
    }

    private boolean smaller(int[] ints, String s1, String s2) {
        int p = 0;
        while (p < s1.length() || p < s2.length()) {
            if (p >= s1.length() || p >= s2.length()) return s1.length() < s2.length();
            if (ints[s1.charAt(p) - 'a'] > ints[s2.charAt(p) - 'a']) return false;
            if (ints[s1.charAt(p) - 'a'] < ints[s2.charAt(p) - 'a']) return true;
            p++;
        }
        return true;
    }
}
