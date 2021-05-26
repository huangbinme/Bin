package com.leetcode;

import org.testng.annotations.Test;

public class Solution_79Test {

    @Test
    public void testExist() {
        Solution_79 solution_79 = new Solution_79();
        char[][] chars = new char[3][3];
        chars[0] = new char[]{'C', 'A', 'A'};
        chars[1] = new char[]{'A', 'A', 'A'};
        chars[2] = new char[]{'B', 'C', 'D'};
        System.out.println(solution_79.exist(chars, "AAB"));
    }
}