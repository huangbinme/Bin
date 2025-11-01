package com.review;

public class Solution_lcr_139 {
    public int[] trainingPlan(int[] actions) {
        int l = 0, r = actions.length - 1;
        while (l < r) {
            while (l < r && actions[l] % 2 == 1) l++;
            while (l < r && actions[r] % 2 == 0) r--;
            if (l < r) swap(actions, l, r);
        }
        return actions;
    }

    private void swap(int[] actions, int l, int r) {
        int t = actions[l];
        actions[l] = actions[r];
        actions[r] = t;
    }
}
