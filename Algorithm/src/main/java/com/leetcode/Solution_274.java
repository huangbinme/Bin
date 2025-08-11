package com.leetcode;

import java.util.Arrays;

public class Solution_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i <= citations[i]) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
