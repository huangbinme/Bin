package com.leetcode;

public class Solution_852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 1;
        while (l < r) {
            int mid = getMid(l, r);
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
