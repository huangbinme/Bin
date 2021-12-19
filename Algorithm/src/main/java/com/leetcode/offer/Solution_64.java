package com.leetcode.offer;

public class Solution_64 {

    int ans = 0;

    public int sumNums(int n) {
        sum(n);
        return ans;
    }

    private boolean sum(int n) {
        ans += n;
        boolean b = n > 0 && sum(n - 1);
        return b;
    }
}
