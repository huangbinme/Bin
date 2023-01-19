package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] cp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (cp[nums[i] - 1] == 0) {
                cp[nums[i] - 1]++;
            } else {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
