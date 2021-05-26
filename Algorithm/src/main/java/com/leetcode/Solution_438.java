package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();
        List<Integer> ans = new ArrayList<>();
        int[] slidFreq = new int[26];
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            slidFreq[s.charAt(r) - 'a']++;
            if (r - l == p.length() - 1) {
                if (Arrays.equals(slidFreq, pFreq)) ans.add(l);
                slidFreq[s.charAt(l++) - 'a']--;
            }
            r++;
        }
        return ans;
    }
}
