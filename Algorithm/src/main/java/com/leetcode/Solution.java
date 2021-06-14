package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Arrays.sort(triplets, Comparator.<int[]>comparingInt(v -> -1 * v[0]).thenComparing(v -> -1 * v[1]).thenComparingInt(v -> -1 * v[2]));
        int[] ints = new int[3];
        Arrays.fill(ints, -1);
        return dfs(triplets, target, 0, 0, ints);
    }

    private boolean dfs(int[][] triplets, int[] target, int targetIndex, int preIndex, int[] ansInts) {
        if (targetIndex == 3) return true;
        for (int i = preIndex; i < triplets.length; i++) {
            int[] ints = triplets[i];
            if (ints[targetIndex] == target[targetIndex]) {
                if (Math.max(ints[targetIndex], ansInts[targetIndex]) != target[targetIndex]) return false;
                int[] copy = Arrays.copyOf(ansInts, 3);
                for (int j = targetIndex; j < 3; j++) {
                    ansInts[j] = Math.max(ansInts[j], ints[j]);
                }
                boolean next = dfs(triplets, target, targetIndex + 1, i, ansInts);
                if (next) return true;
                ansInts = copy;
            }
        }
        return false;
    }
}
