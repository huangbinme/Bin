package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//跳过第一个数字相同
            int target = nums[i] * -1;
            int l = i + 1, r = nums.length - 1, boundL = i + 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    if (!(l > boundL && nums[l] == nums[l - 1])) { // 跳过第二个数字相同
                        List<Integer> sub = Arrays.asList(nums[i], nums[l], nums[r]);
                        ans.add(sub);
                    }
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
