package com.leetcode.offer;

public class Solution_51 {
    int ans = 0;

    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        merge(nums, 0, nums.length);
        return ans;
    }

    private int[] merge(int[] nums, int start, int end) {
        if (end - start == 1) return new int[]{nums[start]};
        int mid = (end - start) / 2 + start;
        int[] l = merge(nums, start, mid);
        int[] r = merge(nums, mid, end);
        return mergeAndCal(l, r);
    }

    private int[] mergeAndCal(int[] nums1, int[] nums2) {
        int[] t = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0, tIndex = 0;
        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] > nums2[n2]) {
                ans += (nums1.length - n1);
                t[tIndex++] = nums2[n2++];
            } else {
                t[tIndex++] = nums1[n1++];
            }
        }
        if (n1 != nums1.length) {
            for (int i = tIndex; i < t.length; i++) {
                t[i] = nums1[n1++];
            }
        } else {
            for (int i = tIndex; i < t.length; i++) {
                t[i] = nums2[n2++];
            }
        }
        return t;
    }
}
