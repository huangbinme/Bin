package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_79Test {

    @Test
    public void testExist() {
        Solution_79 solution79 = new Solution_79();
        char[][] chars = new char[3][4];
        chars[0] = new char[]{'A', 'B', 'C', 'E'};
        chars[1] = new char[]{'S', 'F', 'C', 'S'};
        chars[2] = new char[]{'A', 'D', 'E', 'E'};
        System.out.println(solution79.exist(chars,"ABCB"));
    }
}