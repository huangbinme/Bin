package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> deque = new PriorityQueue(Comparator.naturalOrder());
        for (int i = 0; i < arr.length; i++) {
            deque.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = deque.poll();
        }
        return ans;
    }
}
