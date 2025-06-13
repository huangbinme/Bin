package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                    if (sum > target || sum > Integer.MAX_VALUE) {
                        r--;
                    } else if (sum < target || sum < Integer.MIN_VALUE) {
                        l++;
                    } else {
                        if (!(l > j + 1 && nums[l] == nums[l - 1])) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        }
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
