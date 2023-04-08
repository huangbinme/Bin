package com.leetcode;

import java.util.Arrays;

public class Solution_2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k){
        int sum = Arrays.stream(reward2).sum();
        int[] ints = new int[reward1.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(ints);
        for (int i = 0; i < k; i++) {
            sum += ints[ints.length - 1 - i];
        }
        return sum;
    }
}
