package com.leetcode;

public class Solution_1144 {
        public int movesToMakeZigzag(int[] nums) {
            if (nums.length <= 1) return 0;
            //Sign: 0->small, 1->large
            return Math.min(cal(nums, 0), cal(nums, 1));
        }

        private int cal(int[] nums, int sign) {
            int preNum = nums[0], ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if ((sign == 0 && preNum > nums[i]) || (sign == 1 && preNum < nums[i])) {
                    preNum = nums[i];
                } else {
                    ans += Math.abs(nums[i] - preNum) + 1;
                    preNum = sign == 0 ? preNum - 1 : nums[i];
                }
                sign = sign == 0 ? 1 : 0;
            }
            return ans;
        }
}
