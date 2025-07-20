package com.review;

import java.util.HashMap;
import java.util.Map;

public class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int find = preSum[i] - k;
            ans += map.getOrDefault(find, 0);
            map.merge(preSum[i], 1, Integer::sum);
        }
        return ans;
    }
}
