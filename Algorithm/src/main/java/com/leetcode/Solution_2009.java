package com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2009 {
    public int minOperations(int[] nums) {
        int[] distinct = IntStream.of(nums).distinct().toArray();
        Arrays.sort(distinct);
        int ans = nums.length - 1, l = 0, r = 0, show = 0, targetLength = nums.length;
        while (r < distinct.length) {
            while (distinct[r] > distinct[l] + targetLength - 1) {
                l++;
                show--;
            }
            show++;
            r++;
            ans = Math.min(ans, targetLength - show);
        }
        return ans;
    }
}
