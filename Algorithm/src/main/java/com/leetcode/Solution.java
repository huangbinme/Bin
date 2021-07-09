package com.leetcode;

public class Solution {
    int ans = 0;

    public int numWays(int n, int[][] relation, int k) {
        dfs(n, relation, k, 0, 0);
        return ans;
    }

    private void dfs(int n, int[][] relation, int k, int passCount, int cur) {
        if (passCount == k) {
            if (cur == n - 1) ans++;
            return;
        }
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] == cur) {
                dfs(n, relation, k, passCount + 1, relation[i][1]);
            }
        }
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int majorityElement(int[] nums) {
        int count = 0, ele = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                ele = nums[i];
            } else {
                count = nums[i] == ele ? count + 1 : count - 1;
                ele = count == 0 ? -1 : ele;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) sum++;
        }
        return sum > nums.length / 2 ? ele : -1;
    }
}
