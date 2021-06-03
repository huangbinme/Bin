package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += (nums[i] == 0 ? -1 : nums[i]);
            if (map.containsKey(preSum)) {
                ans = Math.max(ans, i - map.get(preSum) + 1);
            } else {
                map.put(preSum, i + 1);
            }

        }
        return ans;
    }
}
