package com.solutions;

public class Solution_1734 {

    public int[] decode(int[] encoded) {
        int[] ans = new int[encoded.length + 1];
        int base = 0;
        for (int i = 1; i <= ans.length; i++) {
            base ^= i;
        }
        int encodedBase = 0;
        for (int i = 0; i < encoded.length; i += 2) {
            encodedBase ^= encoded[i];
        }
        int last = encodedBase ^ base;
        ans[ans.length - 1] = last;
        for (int i = encoded.length - 1; i >= 0; i--) {
            ans[i] = encoded[i] ^ ans[i + 1];
        }
        return ans;
    }
}
