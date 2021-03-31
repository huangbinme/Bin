package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_51Test {

    @Test
    public void testSolveNQueens() {
        Solution_51 solution_51 = new Solution_51();
        solution_51.solveNQueens(9);
    }
}