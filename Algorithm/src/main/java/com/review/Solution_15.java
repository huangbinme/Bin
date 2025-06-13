package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1, r = nums.length - 1, target = nums[i] * -1;
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    if (!(l > i + 1 && nums[l] == nums[l - 1])) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    }
                    l++;
                    r--;
                }
            }
        }
        //-4,-1,-1,0,1,2
        return ans;
    }
}
