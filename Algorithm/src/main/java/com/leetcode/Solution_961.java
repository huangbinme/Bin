package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_961 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return 0;
    }
}
