package com.leetcode;

public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[nums1.length];
        int i = 0, j = 0, copyIndex = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                copy[copyIndex++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            }else {
                copy[copyIndex++] = i == m ? nums2[j++] : nums1[i++];
            }
        }
        for (int k = 0; k < copy.length; k++) {
            nums1[k] = copy[k];
        }
    }
}
