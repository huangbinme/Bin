package com.leetcode;

public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length;
        int[] copy = new int[nums.length];
        while (true) {
            int cIndexL = l, cIndexR = r - 1, base = nums[l];
            for (int i = l + 1; i < r; i++) {
                if (nums[i] < base) copy[cIndexL++] = nums[i];
                if (nums[i] > base) copy[cIndexR--] = nums[i];
            }
            if (cIndexL <= k && k <= cIndexR) return base;
            if (cIndexL > k) r = cIndexL;
            if (k > cIndexR) l = cIndexR + 1;
            for (int i = l; i < r; i++) {
                nums[i] = copy[i];
            }
        }
    }
}
