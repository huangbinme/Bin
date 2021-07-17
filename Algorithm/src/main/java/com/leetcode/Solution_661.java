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
}
