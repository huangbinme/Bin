package com.leetcode;

public class Solution_190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int low = n % 2;
            //带符号补高位
            n = n >>> 1;
            ans = ans << 1;
            ans += low;
        }
        return ans;
    }
}
