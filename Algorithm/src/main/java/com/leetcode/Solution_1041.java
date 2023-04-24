package com.leetcode;

public class Solution_1041 {
    public boolean isRobotBounded(String instructions) {
        Direct d = Direct.N;
        int x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'G') {
                if (Direct.N.equals(d)) {
                    y++;
                } else if (Direct.S.equals(d)) {
                    y--;
                } else if (Direct.W.equals(d)) {
                    x--;
                } else {
                    x++;
                }
            } else {
                d = Direct.turn(d, instructions.charAt(i));
            }
        }
        return (x == 0 && y == 0) || (!Direct.N.equals(d));
    }

    public enum Direct {
        N, S, W, E;
        public static Direct turn(Direct d, char s) {
            if (N.equals(d)) {
                return s == 'L' ? W : E;
            } else if (S.equals(d)) {
                return s == 'R' ? W : E;
            } else if (W.equals(d)) {
                return s == 'R' ? N : S;
            } else {
                return s == 'L' ? N : S;
            }
        }
    }
}
