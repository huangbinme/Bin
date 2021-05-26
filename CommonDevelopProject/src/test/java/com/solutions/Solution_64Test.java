package com.solutions;

import junit.framework.TestCase;

public class Solution_64Test extends TestCase {

    public void testMinPathSum() {
        Solution_64 solution_64 = new Solution_64();
        int[][] ints = new int[3][3];
        ints[0] = new int[]{1,3,1};
        ints[1] = new int[]{1,5,1};
        ints[2] = new int[]{4,2,1};

        System.out.println(solution_64.minPathSum(ints));
    }
}