package com.review;

public class Solution_215 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1;
        int[] copy = new int[nums.length];
        while (true) {
            int copyL = l, copyR = r, pivotNum = nums[l];
            for (int i = l; i <= r; i++) {
                if (nums[i] < pivotNum) {
                    copy[copyL++] = nums[i];
                } else if (nums[i] > pivotNum) {
                    copy[copyR--] = nums[i];
                }
            }
            if (copyL <= k && k <= copyR) return pivotNum;
            if (k < copyL) r = copyL - 1;
            if (k > copyR) l = copyR + 1;
            for (int i = l; i <= r; i++) {
                nums[i] = copy[i];
            }
        }
    }
}
