package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i] + difference, 1);
            } else {
                int newLength = map.get(arr[i]) + 1;
                int existLength = map.getOrDefault(arr[i] + difference, -1);
                map.put(arr[i] + difference, Math.max(newLength, existLength));
                ans = Math.max(ans, Math.max(newLength, existLength));
            }
        }
        return ans;
    }
}
