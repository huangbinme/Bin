package com.leetcode;

public class Solution_661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int count = 0, sum = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if (validate(img, k, l)) {
                            count++;
                            sum += img[k][l];
                        }
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }

    private boolean validate(int[][] img, int i, int j) {
        return (i >= 0 && i < img.length && j >= 0 && j < img[0].length);
    }

    public int[][] imageSmoother2(int[][] img) {
        int[][] preSum = new int[img.length + 3][img[0].length + 3];
        for (int i = 2; i < preSum.length; i++) {
            for (int j = 2; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + (i - 2 < img.length && j - 2 < img[0].length ? img[i - 2][j - 2] : 0) - preSum[i - 1][j - 1];
            }
        }
        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                int sum = preSum[i + 3][j + 3] - preSum[i][j + 3] - preSum[i + 3][j] + preSum[i][j];
                int c = ((i - 1 >= 0 ? 1 : 0) + 1 + (i + 1 < img.length ? 1 : 0)) *
                        ((j - 1 >= 0 ? 1 : 0) + 1 + (j + 1 < img[0].length ? 1 : 0));
                ans[i][j] = sum / c;
            }
        }
        return ans;
    }
}
