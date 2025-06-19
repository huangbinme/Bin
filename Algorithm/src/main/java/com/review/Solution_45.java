package com.review;

public class Solution_45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int ans = 0, l = 0;
        while (l < nums.length) {
            if (l == nums.length - 1) return ans;
            if (l + nums[l] >= nums.length - 1) return ans + 1;
            int j = l, k = -1;
            for (int i = l; i < nums.length && i <= l + nums[l]; i++) {
                if (i + nums[i] > k) {
                    k = i + nums[i];
                    j = i;
                }
            }
            l = j;
            ans++;
        }
        return ans;
    }
}
