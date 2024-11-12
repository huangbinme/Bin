package com.leetcode;

public class Solution_3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int l = 0, r = 0, oneCount = 0, zeroCount = 0, ans = 0;
        while (r < s.length()) {
            while (!(oneCount + (s.charAt(r) == '1' ? 1 : 0) <= k || zeroCount + (s.charAt(r) == '0' ? 1 : 0) <= k)) {
                if (s.charAt(l) == '1') {
                    oneCount--;
                } else {
                    zeroCount--;
                }
                l++;
            }
            ans += (1 + oneCount + zeroCount);
            if (s.charAt(r) == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
            r++;
        }
        return ans;
    }
}
