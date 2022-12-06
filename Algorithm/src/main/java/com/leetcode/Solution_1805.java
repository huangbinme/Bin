package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_1805 {
    public int numDifferentIntegers(String word) {
        int l = 0, r = 0;
        Set<String> set = new HashSet<>();
        while (l < word.length()) {
            if (word.charAt(l) - '0' >= 0 && word.charAt(l) - '0' <= 9) {
                r = l;
                while (r < word.length() && word.charAt(r) - '0' >= 0 && word.charAt(r) - '0' <= 9) r++;
                while (l < r - 1 && word.charAt(l) == '0') l++;
                set.add(word.substring(l, r));
                l = r;
            } else {
                l++;
            }
        }
        return set.size();
    }
}
