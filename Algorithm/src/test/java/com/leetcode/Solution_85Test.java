package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_85Test {

    @Test
    public void testMaximalRectangle() {
        char[][] chars = new char[4][5];
        chars[0] = new char[]{'1', '0', '1', '0', '0'};
        chars[1] = new char[]{'1', '0', '1', '1', '1'};
        chars[2] = new char[]{'1', '1', '1', '1', '1'};
        chars[3] = new char[]{'1', '0', '0', '1', '0'};
        Solution_85 s = new Solution_85();
        System.out.println(s.maximalRectangle(chars));
    }

    @Test
    public void testMaximalRectangle2() {
        char[][] chars = new char[200][200];
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                chars[i][j] = '1';
            }
        }
        Solution_85 s = new Solution_85();
        System.out.println(s.maximalRectangle(chars));
    }
}