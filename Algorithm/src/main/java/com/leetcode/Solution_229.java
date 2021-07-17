package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_229 {
    public List<Integer> majorityElement(int[] nums) {
        int candidateA = Integer.MAX_VALUE, aCount = 0;
        int candidateB = Integer.MAX_VALUE, bCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (aCount == 0) {
                candidateA = nums[i];
                aCount++;
            } else {
                aCount = nums[i] == candidateA ? (aCount + 1) : (aCount - 1);
                candidateA = aCount == 0 ? Integer.MAX_VALUE : candidateA;
            }

            if (bCount == 0) {
                candidateB = nums[i];
                bCount++;
            } else {
                bCount = nums[i] == candidateB ? (bCount + 1) : (bCount - 1);
                candidateB = bCount == 0 ? Integer.MAX_VALUE : candidateB;
            }
        }
        List<Integer> ans = new ArrayList<>();
        aCount = 0;
        bCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidateA != Integer.MAX_VALUE && nums[i] == candidateA) {
                aCount++;
            }
            if (candidateB != Integer.MAX_VALUE && nums[i] == candidateB) {
                bCount++;
            }
        }
        if (aCount > nums.length / 3) {
            ans.add(candidateA);
        }
        if (bCount > nums.length / 3 && (candidateA == Integer.MAX_VALUE || candidateA != candidateB)) {
            ans.add(candidateB);
        }
        return ans;
    }
}
