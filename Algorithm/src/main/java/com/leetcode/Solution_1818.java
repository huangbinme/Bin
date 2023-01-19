package com.leetcode;

import java.util.Arrays;

public class Solution_1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] copy = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(copy);
        long sum = 0, ans = 0, mod = 1000000007;
        for (int i = 0; i < nums1.length; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        ans = sum;
        for (int i = 0; i < nums1.length; i++) {
            int newNum = getNew(copy, nums2[i]);
            int preAbs = Math.abs(nums1[i] - nums2[i]);
            int newAbs = Math.abs(newNum - nums2[i]);
            long newAns = (sum - preAbs + newAbs);
            ans = Math.min(ans, newAns);
        }
        return (int) (ans % mod);
    }

    private int getNew(int[] copy, int target) {
        if (copy[copy.length - 1] <= target) return copy[copy.length - 1];
        int l = 0, r = copy.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (copy[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l > 0 && Math.abs(copy[l] - target) > Math.abs(copy[l - 1] - target)) return copy[l - 1];
        return copy[l];
    }
}
