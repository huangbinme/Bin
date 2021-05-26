package com.leetcode;

public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int[] newArray = new int[nums1.length];
        int new_cursor = 0;
        int m_cursor = 0;
        int n_cursor = 0;
        while (m_cursor != m && n_cursor != n) {
            if (nums1[m_cursor] <= nums2[n_cursor]) {
                newArray[new_cursor++] = nums1[m_cursor++];
            } else {
                newArray[new_cursor++] = nums2[n_cursor++];
            }
        }
        if (m_cursor == m) {
            while (n_cursor != n) {
                newArray[new_cursor++] = nums2[n_cursor++];
            }
        } else {
            while (m_cursor != m) {
                newArray[new_cursor++] = nums1[m_cursor++];
            }
        }
        for (int i = 0; i < newArray.length; i++) {
            nums1[i] = newArray[i];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int new_cursor = nums1.length - 1;
        int m_cursor = m - 1;
        int n_cursor = n - 1;
        while (m_cursor >= 0 && n_cursor >= 0) {
            if (nums1[m_cursor] >= nums2[n_cursor]) {
                nums1[new_cursor--] = nums1[m_cursor--];
            } else {
                nums1[new_cursor--] = nums2[n_cursor--];
            }
        }
        if (m_cursor < 0) {
            while (n_cursor >= 0) {
                nums1[new_cursor--] = nums2[n_cursor--];
            }
        } else {
            while (m_cursor >= 0) {
                nums1[new_cursor--] = nums1[m_cursor--];
            }
        }
    }
}
