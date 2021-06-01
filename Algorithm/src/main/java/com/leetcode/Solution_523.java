package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int key = preSum % k;
            if (map.containsKey(key)) {
                if ((preSum - nums[i]) % k != key) return true;
                if (map.get(key) > 1) return true;
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return false;
    }
}
