package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int[] copy = new int[nums.length + 2];
        copy[0] = lower - 1;
        copy[copy.length - 1] = upper + 1;
        System.arraycopy(nums, 0, copy, 1, nums.length);
        for (int i = 0; i < copy.length - 1; i++) {
            String s = getRange(copy[i], copy[i + 1]);
            if (s != null) ans.add(s);
        }
        return ans;
    }

    private String getRange(int l, int r) {
        l++;
        r--;
        if (l == r) {
            return String.valueOf(l);
        } else if (l < r) {
            return l + "->" + r;
        } else {
            return null;
        }
    }
}
