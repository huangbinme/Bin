package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            map.put(preSum[i + 1], i + 1);
        }
        for (int i = 0; i < preSum.length - 1; i++) {
            if (map.containsKey(preSum[i] + k)) {
                ans = Math.max(ans, map.get(preSum[i] + k) - i);
            }
        }
        return ans;
    }
}
