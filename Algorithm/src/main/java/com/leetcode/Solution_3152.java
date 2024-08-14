package com.leetcode;

import java.util.TreeSet;

public class Solution_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                set.add(i);
            }
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] ints = queries[i];
            Integer floor = set.floor(ints[1] - 1);
            Integer ceiling = set.ceiling(ints[0]);
            if (floor != null && ceiling != null && ((floor >= ints[0] && floor < ints[1]) || (ceiling >= ints[0] && ceiling < ints[1]))) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }
        return ans;
    }
}
