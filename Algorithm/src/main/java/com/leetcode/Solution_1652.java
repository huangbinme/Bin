package com.leetcode;

public class Solution_1652 {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) return ans;
        int r = k > 0 ? k : code.length - 1, sum = 0;
        for (int i = r - Math.abs(k) + 1; i <= r; i++) {
            sum += code[i];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = sum;
            r++;
            sum += code[r % code.length];
            sum -= code[(r - Math.abs(k)) % code.length];
        }
        return ans;
    }
}
