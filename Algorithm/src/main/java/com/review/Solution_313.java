package com.review;

public class Solution_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] p = new int[primes.length];
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < p.length; j++) {
                int k = ans[p[j]] * primes[j];
                if (k > 0) min = Math.min(min, k);
            }
            ans[i] = min;
            for (int j = 0; j < p.length; j++) {
                if (min == ans[p[j]] * primes[j]) p[j]++;
            }
        }
        return ans[ans.length - 1];
    }
}
