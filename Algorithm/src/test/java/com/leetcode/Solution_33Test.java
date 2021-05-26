package com.leetcode;

import junit.framework.TestCase;

public class Solution_33Test extends TestCase {

    public void testSearch() {
        Solution_33 solution_33 = new Solution_33();
        int[] ints = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution_33.search(ints,0));
    }

    public void testSearc2() {
        Solution_33 solution_33 = new Solution_33();
        int[] ints = new int[]{5,1,3};
        System.out.println(solution_33.search(ints,3));
    }
}