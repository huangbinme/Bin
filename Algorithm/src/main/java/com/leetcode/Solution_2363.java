package com.leetcode;

import java.util.*;

public class Solution_2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < Math.max(items1.length, items2.length); i++) {
            if (i < items1.length) map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) + items1[i][1]);
            if (i < items2.length) map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        ans.sort(Comparator.comparingInt(v -> v.get(0)));
        return ans;
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] note = new int[1001];
        int maxSize = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < maxSize; i++) {
            if (i < nums1.length) note[nums1[i][0]] += nums1[i][1];
            if (i < nums2.length) note[nums2[i][0]] += nums2[i][1];
        }
        int ansSize = 0;
        for (int i = 1; i < note.length; i++) {
            if (note[i] != 0) ansSize++;
        }
        int[][] ans = new int[ansSize][2];
        int index = 0;
        for (int i = 1; i < note.length; i++) {
            if (note[i] != 0) {
                ans[index++] = new int[]{i, note[i]};
            }
        }
        return ans;
    }

    public int minOperations(int n) {
        int max = 1, num = 1;
        while (num <= n) {
            max++;
            num *= 2;
        }
        int[][] dp = new int[max][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else {
                    int delegateI = (int) Math.pow(2, i);
                    if (delegateI == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = (j - delegateI >= 1) ? Math.min(dp[i - 1][j], dp[i][j - delegateI] + 1) : dp[i - 1][j];
                        if (delegateI - j >= 1 && delegateI - j < j) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][delegateI - j] + 1);
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int minOperations2(int n) {
        int ans = 1;
        while ((n & (n - 1)) != 0) {
            int low = n & -n;
            if ((low << 1 & n) != 0) {
                n += low;
            } else {
                n -= low;
            }
            ans++;
        }
        return ans;
    }
}
