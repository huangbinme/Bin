package com.leetcode;

import java.util.Comparator;
import java.util.TreeMap;

public class Solution_1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.naturalOrder());
        int l = 0, r = 0, ans = 1;
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (Math.abs(map.lastKey() - map.firstKey()) > limit && l < r) {
                Integer freq = map.get(nums[l]);
                if (freq > 1) {
                    map.put(nums[l], freq - 1);
                } else {
                    map.remove(nums[l]);
                }
                l++;
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
