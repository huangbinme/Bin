package com.leetcode;

public class Solution_440 {
    public int findKthNumber(int n, int k) {
        int curNode = 1;
        k--;
        while (k > 0) {
            int c = count(n, curNode);
            if (c <= k) {
                k -= c;
                curNode += 1;
            } else {
                k -= 1;
                curNode *= 10;
            }
        }
        return curNode;
    }

    private int count(int n, int node) {
        long l = node, r = node + 1, ans = 0;
        while (l <= n) {
            ans += Math.min(r - l, n - l + 1);
            l *= 10;
            r *= 10;
        }
        return (int)ans;
    }
}
