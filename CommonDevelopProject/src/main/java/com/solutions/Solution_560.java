package com.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i])) {
                ans += map.get(preSum[i]);
            }
            map.put(k + preSum[i], map.getOrDefault(k + preSum[i], 0) + 1);
        }
        return ans;
    }
}
