package com.leetcode;

public class Solution_978 {
    public int maxTurbulenceSize(int[] arr) {
        int x = 1, y = 0, z = 0, ans = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                y = 0;
                z = 0;
                continue;
            }
            if (arr[i] > arr[i - 1]) {
                y = Math.max(x, z) + 1;
                z = 0;
                ans = Math.max(ans, y);
            } else {
                z = Math.max(x, y) + 1;
                y = 0;
                ans = Math.max(ans, z);
            }
        }
        return ans;
    }
}
