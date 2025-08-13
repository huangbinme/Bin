package com.review;

public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m_p = m - 1, n_p = n - 1, ansP = nums1.length - 1;
        while (m_p >= 0 || n_p >= 0) {
            if (m_p >= 0 && n_p >= 0) {
                nums1[ansP--] = nums1[m_p] > nums2[n_p] ? nums1[m_p--] : nums2[n_p--];
            } else {
                nums1[ansP--] = m_p < 0 ? nums2[n_p--] : nums1[m_p--];
            }
        }
    }
}
