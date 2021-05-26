package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_7Test {

    @Test
    public void testReverse() {
        Solution_7 solution_7 = new Solution_7();
        System.out.println(solution_7.reverse(-2147483648));
    }
}