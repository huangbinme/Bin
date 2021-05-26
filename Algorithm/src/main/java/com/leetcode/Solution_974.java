package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int num = sum % k < 0 ? sum % k + k : sum % k;
            int add = map.getOrDefault(num, 0);
            ans += add;
            map.put(num, add + 1);
        }
        return ans;
    }
}
