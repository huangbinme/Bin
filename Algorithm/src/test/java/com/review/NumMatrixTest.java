package com.review;

import org.testng.annotations.Test;

public class NumMatrixTest {

    @Test
    public void testSumRegion() {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};
        NumMatrix numMatrix = new NumMatrix(matrix);
        //numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}