package com.review;

public class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        int sumLength = nums1.length + nums2.length;
        int p1 = 0, p2 = 0;
        for (int i = 0; i < sumLength / 2 + 1; i++) {
            int j = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int k = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            if (j <= k) {
                p1++;
            } else {
                p2++;
            }
            int curNum = Math.min(j, k);
            n1 = n2;
            n2 = curNum;
        }
        return sumLength % 2 == 0 ? ((double) n1 + n2) / 2 : n2;
    }
}
