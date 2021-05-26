package com.solutions;

import java.util.Arrays;

public class Solution_395 {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int[] slidFre = new int[26];
        for (int i = 1; i <= 26; i++) {
            int l = 0, r = 0, slidCharType = 0, slidLargerKCount = 0;
            while (r < s.length()) {
                int index = s.charAt(r) - 'a';
                if (slidFre[index] == 0) slidCharType++;
                slidFre[index]++;
                if (slidFre[index] == k) slidLargerKCount++;
                if (slidCharType == i && slidLargerKCount == slidCharType) ans = Math.max(ans, r - l + 1);
                while (slidCharType > i) {
                    int lIndex = s.charAt(l) - 'a';
                    slidFre[lIndex]--;
                    if (slidFre[lIndex] == 0) slidCharType--;
                    if (slidFre[lIndex] == k - 1) slidLargerKCount--;
                    l++;
                }
                r++;
            }
            Arrays.fill(slidFre, 0);
        }
        return ans;
    }
}
