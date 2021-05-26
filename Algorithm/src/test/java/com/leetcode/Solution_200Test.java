package com.leetcode;

import org.testng.annotations.Test;

public class Solution_200Test {

    @Test
    public void testNumIslands() {
        Solution_200 solution_200 = new Solution_200();
        char[][] chars = new char[3][3];
        chars[0] = new char[]{'1','1','1'};
        chars[1] = new char[]{'0','1','0'};
        chars[2] = new char[]{'1','1','1'};
        System.out.println(solution_200.numIslands(chars));
    }
}