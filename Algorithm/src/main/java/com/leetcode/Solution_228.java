package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            if (l != r && nums[r - 1] != nums[r] - 1) {
                ans.add(getStr(nums, l, r));
                l = r;
                continue;
            }
            r++;
        }
        ans.add(getStr(nums, l, r));
        return ans;
    }

    private String getStr(int[] nums, int l, int r) {
        return l != r - 1 ? nums[l] + "->" + nums[r - 1] : String.valueOf(nums[l]);
    }
}
