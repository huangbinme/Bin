package com.solutions;

import java.util.Arrays;

public class Solution_567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] slidFreq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s2.length()) {
            slidFreq[s2.charAt(r) - 'a']++;
            if (r - l == s1.length() - 1) {
                if (Arrays.equals(s1Freq, slidFreq)) return true;
                slidFreq[s2.charAt(l++) - 'a']--;
            }
            r++;
        }
        return false;
    }
}
