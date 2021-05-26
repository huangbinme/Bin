package com.solutions;

import java.util.Arrays;

public class Solution_424 {
    public int characterReplacement(String s, int k) {
        int[] ints = new int[26];
        int l = 0, r = 0, ans = 0, maxCount = 0;
        while (r < s.length()) {
            int i = s.charAt(r) - 'A';
            ints[i]++;
            maxCount = Math.max(maxCount, ints[i]);
            r++;
            while (r - l - maxCount > k) {
                ints[s.charAt(l++) - 'A']--;
                maxCount = Arrays.stream(ints).max().getAsInt();
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
