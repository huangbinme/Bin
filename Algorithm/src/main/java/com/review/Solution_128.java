package com.review;

import java.util.HashSet;
import java.util.Set;

public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int ans = Integer.MIN_VALUE, start = Integer.MIN_VALUE;
        for (Integer num : numSet) {
            if (ans != Integer.MIN_VALUE && start <= num && num < start + ans) continue;
            int n = num + 1;
            while (numSet.contains(n)) n++;
            if (n - num > ans) {
                ans = n - num;
                start = num;
            }
        }
        return ans;
    }
}
