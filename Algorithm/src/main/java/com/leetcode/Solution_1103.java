package com.leetcode;

public class Solution_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0, j = 1;
        while (candies > 0) {
            ans[i % ans.length] += Math.min(candies, j);
            candies -= j;
            j++;
            i++;
        }
        return ans;
    }
}
