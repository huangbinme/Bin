package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[][] nums1Copy = new int[nums1.length][];
        int[][] nums2Copy = new int[nums2.length][];
        for (int i = 0; i < nums1.length; i++) {
            nums1Copy[i] = new int[]{nums1[i], i};
            nums2Copy[i] = new int[]{nums2[i], i};
        }
        Arrays.sort(nums1Copy, Comparator.comparingInt(v -> v[0]));
        Arrays.sort(nums2Copy, Comparator.comparingInt(v -> v[0]));
        int[] ans = new int[nums1.length];
        int l1 = 0, r1 = nums1.length - 1, l2 = 0, r2 = nums2.length - 1;
        while (l1 <= r1 && l2 <= r2) {
            if (nums2Copy[l2][0] < nums1Copy[l1][0]) {
                ans[nums2Copy[l2][1]] = nums1[nums1Copy[l1][1]];
                l1++;
                l2++;
            } else {
                ans[nums2Copy[r2][1]] = nums1[nums1Copy[l1][1]];
                l1++;
                r2--;
            }
        }
        return ans;
    }
}
