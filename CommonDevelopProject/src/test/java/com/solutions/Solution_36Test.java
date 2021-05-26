package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_36Test {

    @Test
    public void testIsValidSudoku() {
        char[][] chars = new char[9][9];
        chars[0] = new char[]{'.','.','.','.','5','.','.','1','.'};
        chars[1] = new char[]{'.','4','.','3','.','.','.','.','.'};
        chars[2] = new char[]{'.','.','.','.','.','3','.','.','1'};
        chars[3] = new char[]{'8','.','.','.','.','.','.','2','.'};
        chars[4] = new char[]{'.','.','2','.','7','.','.','.','.'};
        chars[5] = new char[]{'.','1','5','.','.','.','.','.','.'};
        chars[6] = new char[]{'.','.','.','.','.','2','.','.','.'};
        chars[7] = new char[]{'.','2','.','9','.','.','.','.','.'};
        chars[8] = new char[]{'.','.','4','.','.','.','.','.','.'};
        Solution_36 solution_36 = new Solution_36();
        System.out.println(solution_36.isValidSudoku(chars));
    }
}