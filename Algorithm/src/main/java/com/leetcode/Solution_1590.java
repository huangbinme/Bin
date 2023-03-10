package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1590 {
    public int minSubarray(int[] nums, int p) {
        int[] preSum = new int[nums.length + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            preSum[i] %= p;
        }
        int target = preSum[preSum.length - 1] % p;
        if (target == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < preSum.length; i++) {
            int j = (preSum[i] - target + p) % p;
            if (map.containsKey(j)) {
                ans = Math.min(ans, i - map.get(j));
            }
            map.put(preSum[i], i);
        }
        return ans == Integer.MAX_VALUE || ans == nums.length ? -1 : ans;
    }
}
