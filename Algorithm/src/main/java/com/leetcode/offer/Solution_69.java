package com.leetcode.offer;

public class Solution_69 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            if (arr[mid + 1] > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
