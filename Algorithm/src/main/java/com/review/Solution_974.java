package com.review;

import java.util.HashMap;
import java.util.Map;

public class Solution_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = mod(sum, k);
            ans += map.getOrDefault(sum, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return ans;
    }

    private int mod(int i, int k) {
        return i % k < 0 ? i % k + k : i % k;
    }
}
