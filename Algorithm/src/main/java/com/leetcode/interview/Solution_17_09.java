package com.leetcode.interview;

public class Solution_17_09 {
    public int getKthMagicNumber(int k) {
        int[] ans = new int[k + 1];
        ans[1] = 1;
        int p1 = 1, p2 = 1, p3 = 1, l = 2;
        for (int i = 0; i < k - 1; i++) {
            int n1 = ans[p1] * 3, n2 = ans[p2] * 5, n3 = ans[p3] * 7;
            int min = Math.min(n1, Math.min(n2, n3));
            if (min == n1) p1++;
            if (min == n2) p2++;
            if (min == n3) p3++;
            ans[l++] = min;
        }
        return ans[ans.length - 1];
    }
}
