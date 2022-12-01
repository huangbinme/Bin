package com.leetcode;

public class Solution_769 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, bound = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == bound) ans++;
            if (arr[i] >= i) bound = Math.max(bound, arr[i] + 1);
        }
        return ans;
    }
}
