package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ints[0] = i;
                ints[1] = map.get(target - nums[i]);
                break;
            }
            map.put(target - nums[i], i);
        }
        return ints;
    }
}
