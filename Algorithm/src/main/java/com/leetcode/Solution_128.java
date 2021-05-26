package com.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = Arrays.stream(nums).distinct().boxed().collect(Collectors.toSet());
        int longestSize = 1;
        for (Integer integer : set) {
            if (!set.contains(integer - 1)) {
                int subListMin = integer;
                int loopNum = subListMin + 1;
                while (set.contains(loopNum)) {
                    loopNum++;
                    longestSize = Math.max(longestSize, loopNum - subListMin);
                }
            }
        }
        return longestSize;
    }
}
