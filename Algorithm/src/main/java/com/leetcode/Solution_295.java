package com.leetcode;

import java.util.Arrays;

public class Solution_295 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        int[] win = new int[k];
        for (int i = 0; i < k; i++) {
            win[i] = nums[i];
        }
        Arrays.sort(win);
        int x = 0;
        ans[x++] = getMid(win);
        for (int i = k; i < nums.length; i++) {
            int remove = nums[i - k], add = nums[i];
            removeFromWin(win, remove);
            addToWin(win, add);
            ans[x++] = getMid(win);
        }
        return ans;
    }

    private void removeFromWin(int[] win, int remove) {
        int i = Arrays.binarySearch(win, remove);
        while (i < win.length - 1) {
            win[i] = win[i + 1];
            i++;
        }
    }

    private void addToWin(int[] win, int add) {
        System.out.println(Arrays.toString(win));
        int find = Arrays.binarySearch(win, add);
        int insert = find >= 0 ? find : find * -1 - 1;
        int i = win.length - 1;
        while (i > insert) {
            win[i] = win[i - 1];
            i--;
        }
        win[Math.min(insert, win.length - 1)] = add;
    }

    public double getMid(int[] win) {
        if (win.length % 2 == 0) {
            return ((double) win[win.length / 2] + (double)win[win.length / 2 - 1]) / 2.0;
        } else {
            return win[win.length / 2];
        }
    }
}
