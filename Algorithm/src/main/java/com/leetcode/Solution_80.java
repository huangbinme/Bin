package com.leetcode;

public class Solution_80 {
    public int removeDuplicates(int[] nums) {

    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
