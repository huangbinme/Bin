package com.solutions;

public class Solution {
    public boolean checkZeroOnes(String s) {
        return getLength(s, '1') > getLength(s, '0');
    }

    private int getLength(String s, char c) {
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            while (s.charAt(r) != c) {
                r++;
                l = r;
                if (r == s.length()) return ans;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0], preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            ans = Math.max(ans, preSum);
        }
        return ans;
    }
}
