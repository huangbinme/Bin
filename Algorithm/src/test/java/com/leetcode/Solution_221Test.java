package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_221Test {

    @Test
    public void testMaximalSquare() {
        char[][] chars = new char[5][5];
        chars[0] = new char[]{'1', '1', '1', '1', '0'};
        chars[1] = new char[]{'1', '1', '1', '1', '0'};
        chars[2] = new char[]{'1', '1', '1', '1', '1'};
        chars[3] = new char[]{'1', '1', '1', '1', '1'};
        chars[4] = new char[]{'0', '0', '1', '1', '1'};
        Solution_221 s = new Solution_221();
        System.out.println(s.maximalSquare(chars));
    }
}