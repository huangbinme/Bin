package com.leetcode;

import org.testng.annotations.Test;

public class Solution_5178Test {

    @Test
    public void testCountPoints() {
        Solution_5178 solution_5178 = new Solution_5178();
        //points = [[1,3],[3,3],[5,3],[2,2]]
        int[][] points = new int[5][2];
        points[0][0] = 1;
        points[0][1] = 3;

        points[1][0] = 3;
        points[1][1] = 3;

        points[2][0] = 5;
        points[2][1] = 3;

        points[3][0] = 2;
        points[3][1] = 2;

        points[4][0] = 3;
        points[4][1] = 3;

        //[[2,3,1],[4,3,1],[1,1,2]]
        int[][] queries = new int[3][3];
        queries[0][0] = 2;
        queries[0][1] = 3;
        queries[0][2] = 1;

        queries[1][0] = 4;
        queries[1][1] = 3;
        queries[1][2] = 1;

        queries[2][0] = 1;
        queries[2][1] = 1;
        queries[2][2] = 2;
        solution_5178.countPoints(points, queries);
    }
}