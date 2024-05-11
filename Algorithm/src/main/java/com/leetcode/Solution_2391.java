package com.leetcode;

public class Solution_2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            ans += s.length();
        }
        int m = -1, p = -1, g = -1;
        for (int i = garbage.length - 1; i > 0; i--) {
            String s = garbage[i];
            if (m == -1 && s.contains("M")) m = i;
            if (p == -1 && s.contains("P")) p = i;
            if (g == -1 && s.contains("G")) g = i;
            if (m != -1 && p != -1 && g != -1) break;
        }
        int sum = 0;
        for (int i = 0; i < travel.length; i++) {
            sum += travel[i];
            if (i + 1 == m) ans += sum;
            if (i + 1 == p) ans += sum;
            if (i + 1 == g) ans += sum;
        }
        return ans;
    }
}
