package com.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class Solution_17_05 {
    public String[] findLongestSubarray(String[] array) {
        int l = 0, r = 0, len = Integer.MIN_VALUE;
        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ints[i] = isNumber(array[i]) ? 1 : -1;
        }
        int[] preSum = new int[ints.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + ints[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < preSum.length; i++) {
            int index = map.getOrDefault(preSum[i], -1);
            if (index != -1) {
                int subLen = i - index;
                if (subLen > len) {
                    len = subLen;
                    l = index;
                    r = i;
                }
            } else {
                map.put(preSum[i], i);
            }
        }
        if (len == Integer.MIN_VALUE) return new String[0];
        String[] ans = new String[r - l];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = array[l];
            l++;
        }
        return ans;
    }

    private boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)) {
                return false;
            }
        }
        return true;
    }
}
