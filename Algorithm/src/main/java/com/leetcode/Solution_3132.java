package com.leetcode;

import java.util.Arrays;

public class Solution_3132 {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int d1 = nums2[0] - nums1[0], d2 = nums2[0] - nums1[1], d3 = nums2[0] - nums1[2];
        if (check(d3, nums1, nums2)) return d3;
        if (check(d2, nums1, nums2)) return d2;
        return d1;
    }

    private boolean check(int diff, int[] nums1, int[] nums2) {
        int i = 0, j = 0, diffCount = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] + diff == nums2[j]) {
                i++;
                j++;
            } else {
                diffCount++;
                i++;
                if (diffCount > 2) return false;
            }
        }
        return true;
    }
}
