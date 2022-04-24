package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_6041 {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                count[nums[i][j] - 1]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == nums.length) ans.add(i);
        }
        return ans;
    }
}
