package com.leetcode;

public class Solution_832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverse1(image[i]);
        }
        for (int i = 0; i < image.length; i++) {
            reverse2(image[i]);
        }
        return image;
    }

    private void reverse1(int[] ints) {
        int i = 0, j = ints.length - 1;
        while (i < j) {
            swap(ints, i++, j--);
        }
    }

    private void reverse2(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints[i] == 0 ? 1 : 0;
        }
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
