package com.solutions;

public class Solution_5178 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                if (in(queries[i], points[j][0], points[j][1])) count++;
            }
            result[i] = count;
        }
        return result;
    }

    public boolean in(int[] query, int x, int y) {
        return query[2] * query[2] >= (x - query[0]) * (x - query[0]) + (y - query[1]) * (y - query[1]);
    }
}
