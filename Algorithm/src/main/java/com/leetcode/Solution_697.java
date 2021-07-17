package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] ints = map.get(nums[i]);
                ints[0]++;
                ints[2] = i + 1;
                maxCount = Math.max(maxCount, ints[0]);
            } else {
                int[] ints = new int[3];
                ints[0] = 1;
                ints[1] = i;
                ints[1] = i + 1;
                map.put(nums[i], ints);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int[] value : map.values()) {
            if (value[0] == maxCount) {
                ans = Math.min(ans, value[2] - value[1]);
            }
        }
        return ans;
    }
}
