package com.leetcode.offer;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_12Test {

    @Test
    public void testExist() {
        char[][] chars = new char[3][4];
        chars[0] = new char[]{'A','B','C','E'};
        chars[1] = new char[]{'S','F','C','S'};
        chars[2] = new char[]{'A','D','E','E'};
        Solution_12 solution_12 = new Solution_12();
        System.out.println(solution_12.exist(chars, "ABCCED"));
    }
}