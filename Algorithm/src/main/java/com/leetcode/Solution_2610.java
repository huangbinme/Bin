package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = new int[201];
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            maxCount = Math.max(maxCount, count[nums[i]]);
        }
        for (int i = 0; i < maxCount; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 1; i < count.length; i++) {
            int num = i, numCount = count[i];
            for (int j = 0; j < numCount; j++) {
                ans.get(j).add(num);
            }
        }
        return ans;
    }
}
