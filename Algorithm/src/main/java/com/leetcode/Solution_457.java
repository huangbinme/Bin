package com.leetcode;

public class Solution_457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        boolean[] booleans = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i]) continue;
            if (check(booleans, nums, i)) return true;
        }
        return false;
    }

    private boolean check(boolean[] booleans, int[] nums, int start) {
        int head = nums[start], slow = start, fast = start;
        booleans[start] = true;
        do {
            slow = getNext(nums, slow);
            if (nums[slow] * head < 0 || nums[fast] * head < 0) return false;
            fast = getNext(nums, fast);
            if (nums[fast] * head < 0) return false;
            fast = getNext(nums, fast);
            if (nums[fast] * head < 0) return false;
            booleans[slow] = true;
            booleans[fast] = true;
        } while (slow != fast);
        return slow != getNext(nums, slow);
    }

    private int getNext(int[] nums, int cur) {
        return cur + nums[cur] >= 0 ? (cur + nums[cur]) % nums.length : nums.length - Math.abs((cur + nums[cur]) % nums.length);
    }
}
