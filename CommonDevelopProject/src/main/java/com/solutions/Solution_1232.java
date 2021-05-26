package com.solutions;

public class Solution_1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        if (coordinates[0][0] == coordinates[1][0]) {
            return checkStraightLine_1(coordinates);
        } else if (coordinates[0][1] == coordinates[1][1]) {
            return checkStraightLine_2(coordinates);
        } else {
            return checkStraightLine_3(coordinates);
        }
    }

    private boolean checkStraightLine_3(int[][] coordinates) {
        boolean result = true;
        int a = coordinates[1][1] - coordinates[0][1];
        int b = coordinates[1][0] - coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (a * (coordinates[1][0] - coordinates[i][0]) != b * (coordinates[1][1] - coordinates[i][1])) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkStraightLine_1(int[][] coordinates) {
        boolean result = true;
        for (int i = 0; i < coordinates.length; i++) {
            if (i == 0) continue;
            if (coordinates[i][0] != coordinates[i - 1][0]) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkStraightLine_2(int[][] coordinates) {
        boolean result = true;
        for (int i = 0; i < coordinates.length; i++) {
            if (i == 0) continue;
            if (coordinates[i][1] != coordinates[i - 1][1]) {
                result = false;
                break;
            }
        }
        return result;
    }


}
