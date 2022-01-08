package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0, r = 0;
        List<Integer> list = new ArrayList<>();
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] > nums2[r]) {
                r++;
            } else if (nums1[l] < nums2[r]) {
                l++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[l]) list.add(nums1[l]);
                l++;
                r++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
