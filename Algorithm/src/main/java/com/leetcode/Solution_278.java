package com.leetcode;

public class Solution_278 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = getMid(left, right);
            boolean check = isBadVersion(mid);
            if (check) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return isBadVersion(left) ? left : right;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
